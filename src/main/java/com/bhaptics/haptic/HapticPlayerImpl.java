package com.bhaptics.haptic;

import com.bhaptics.haptic.models.*;
import com.bhaptics.haptic.utils.LogUtils;
import com.bhaptics.haptic.utils.StringUtils;
import com.google.gson.Gson;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class HapticPlayerImpl implements HapticPlayer {
    private String url = "ws://127.0.0.1:15881/v2/feedbacks";
    private EasyClient client;
    private boolean isConnected;

    public HapticPlayerImpl(String appId, String appName) {

        try {
            System.out.println("HapticPlayer()");
            client = new EasyClient(new URI(url+ "?app_id=" +
                    StringUtils.encodeValue(appId) + "&app_name=" +
                    StringUtils.encodeValue(appName)));

            client.connect();

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dispose() {
        LogUtils.log("dispose()");
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
        LogUtils.log("register " + key + ", " + fileContent);
        Gson gson = new Gson();

        Map<String, Object> o = gson.fromJson(fileContent, Map.class);




        RegisterRequest req = new RegisterRequest(
                key,  (o.get("project"))
        );

        PlayerRequest playerRequest = new PlayerRequest();
        playerRequest.addRegister(req);

        client.send(gson.toJson(playerRequest));

    }

    @Override
    public void submit(String key, PositionType positionType, byte[] motorBytes, int durationMillis) {

    }

    @Override
    public void submit(String key, PositionType positionType, PathPoint[] points, int durationMillis) {

    }

    @Override
    public void submit(String key, PositionType positionType, DotPoint[] points, int durationMillis) {

    }

    @Override
    public void submitRegistered(String key) {
        LogUtils.log("submitRegistered: " + key);
        Gson gson = new Gson();

        SubmitRequest req = new SubmitRequest();
        req.setKey(key);
        req.setType("submit");

        PlayerRequest playerRequest = new PlayerRequest();
        playerRequest.addSubmit(req);

        client.send(gson.toJson(playerRequest));

    }

    @Override
    public void submitRegistered(String key, String altKey, RotationOption rotationOption, ScaleOption scaleOption) {

    }

    @Override
    public void turnOff(String key) {

    }

    @Override
    public void turnOff() {

    }

}
