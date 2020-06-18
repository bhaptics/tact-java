package com.bhaptics.haptic;

import com.bhaptics.haptic.models.*;
import com.bhaptics.haptic.models.tact.HapticFeedbackFile;
import com.bhaptics.haptic.utils.HapticPlayerCallback;
import com.bhaptics.haptic.utils.LogUtils;
import com.bhaptics.haptic.utils.StringUtils;
import com.google.gson.Gson;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

public class HapticPlayerImpl implements HapticPlayer {
    private String url = "ws://127.0.0.1:15881/v2/feedbacks";
    private EasyClient client;
    private boolean isConnected;

    private String appId;
    private String appName;
    private boolean retryConnect;

    private Gson gson = new Gson();

    private List<HapticPlayerCallback> callbacks = new ArrayList<>();

    public HapticPlayerImpl(String appId, String appName) {
        this(appId, appName, false);
    }

    public HapticPlayerImpl(String appId, String appName, HapticPlayerCallback hapticPlayerCallback) {
        this(appId, appName, false);
        callbacks.add(hapticPlayerCallback);
    }


    HapticPlayerCallback hapticPlayerCallback = new HapticPlayerCallback() {
        @Override
        public void onConnectionChange(boolean connected) {
            isConnected = connected;

            for (HapticPlayerCallback callback : callbacks) {
                callback.onConnectionChange(connected);
            }
            if (!isConnected) {
                resetConnection();
            }
        }
    };

    public HapticPlayerImpl(String appId, String appName, boolean retryConnect) {
        this.appId = appId;
        this.appName = appName;
        this.retryConnect = retryConnect;

        LogUtils.log("HapticPlayerImpl()");
        connect();

    }

    private void connect() {
        try {
            client = new EasyClient(new URI(url+ "?app_id=" +
                    StringUtils.encodeValue(appId) + "&app_name=" +
                    StringUtils.encodeValue(appName)));

            client.addHapticPlayerCallback(hapticPlayerCallback);
            client.connect();
        } catch (URISyntaxException e) {
            LogUtils.logError("HapticPlayerImpl() " + e.getMessage(), e);
        }
    }

    void resetConnection() {
        new Thread(() -> {
            if (retryConnect) {
                try  {
                    Thread.sleep( 2000 );
                }
                catch (InterruptedException ie)  {
                    LogUtils.trace(ie.getMessage());
                }
                connect();
            }
        } ).start();


    }

    @Override
    public void dispose() {
        LogUtils.log("dispose()");
        try {
            client.closeBlocking();
        } catch (InterruptedException e) {
            LogUtils.log("dispose()" + e.getMessage());
        }
    }

    @Override
    public boolean isPlaying(String key) {
        return false;
    }

    @Override
    public boolean isPlaying() {
        return false;
    }

    @Override
    public void register(String key, String fileContent) {
        LogUtils.trace("register " + key + ", " + fileContent);

        HapticFeedbackFile o = gson.fromJson(fileContent, HapticFeedbackFile.class);

        RegisterRequest req = new RegisterRequest(
                key,  o.getProject()
        );
        sendRegisterRequest(req);
    }

    private void sendRegisterRequest(RegisterRequest req) {
        if (!isConnected) {
            LogUtils.log("not connected.");
            return;
        }

        PlayerRequest playerRequest = new PlayerRequest();
        playerRequest.addRegister(req);

        client.send(gson.toJson(playerRequest));
    }

    private void sendSubmitRequest(SubmitRequest req) {
        if (!isConnected) {
            LogUtils.log("not connected.");
            return;
        }

        PlayerRequest playerRequest = new PlayerRequest();
        playerRequest.addSubmit(req);

        client.send(gson.toJson(playerRequest));
    }

    @Override
    public void submitPath(String key, PositionType positionType, List<PathPoint> points, int durationMillis) {
        SubmitRequest req = new SubmitRequest();
        req.setKey(key);
        req.setType("frame");
        Frame frame = new Frame();
        frame.setDurationMillis(durationMillis);
        frame.setPosition(positionType);
        frame.setDotPoints(Arrays.asList());
        frame.setPathPoints(points);
        req.setFrame(frame);

        sendSubmitRequest(req);
    }

    @Override
    public void submitDot(String key, PositionType positionType, List<DotPoint> points, int durationMillis) {
        SubmitRequest req = new SubmitRequest();
        req.setKey(key);
        req.setType("frame");
        Frame frame = new Frame();
        frame.setDurationMillis(durationMillis);
        frame.setPosition(positionType);
        frame.setDotPoints(points);
        frame.setPathPoints(Arrays.asList());
        req.setFrame(frame);

        sendSubmitRequest(req);
    }

    @Override
    public void submitRegistered(String key) {
        LogUtils.log("submitRegistered: " + key);
        SubmitRequest req = new SubmitRequest();
        req.setKey(key);
        req.setType("key");

        sendSubmitRequest(req);

    }

    @Override
    public void submitRegistered(String key, String altKey, RotationOption rotationOption, ScaleOption scaleOption) {
        LogUtils.log("submitRegistered: " + key);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("altKey", altKey);
        parameters.put("rotationOption", rotationOption);
        parameters.put("scaleOption", scaleOption);

        SubmitRequest req = new SubmitRequest();
        req.setKey(key);
        req.setType("key");
        req.setParameters(parameters);

        sendSubmitRequest(req);
    }

    @Override
    public void turnOff(String key) {
        SubmitRequest req = new SubmitRequest();
        req.setKey(key);
        req.setType("turnOff");

        sendSubmitRequest(req);
    }

    @Override
    public void turnOff() {
        SubmitRequest req = new SubmitRequest();
        req.setKey("");
        req.setType("turnOffAll");

        sendSubmitRequest(req);
    }

}
