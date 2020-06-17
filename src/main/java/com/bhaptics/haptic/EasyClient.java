package com.bhaptics.haptic;

import com.bhaptics.haptic.utils.HapticPlayerCallback;
import com.bhaptics.haptic.utils.LogUtils;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class EasyClient extends WebSocketClient {
    private boolean isConnected = false;

    private List<HapticPlayerCallback> callbacks;

    public EasyClient(URI serverUri) {
        super(serverUri);
        callbacks = new ArrayList<>();
    }

    public void addHapticPlayerCallback(HapticPlayerCallback callback) {
        callbacks.add(callback);
    }

    private void fireCallback() {
        for (HapticPlayerCallback callback : callbacks) {
            callback.onConnectionChange(isConnected);
        }
    }


    @Override
    public void onOpen(ServerHandshake handshakedata) {
        LogUtils.log("connection established.");
        isConnected = true;
        fireCallback();
    }

    @Override
    public void onMessage(String message) {
        LogUtils.trace("received." + message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        LogUtils.trace("connection closed.");
        isConnected = false;
        fireCallback();
    }

    @Override
    public void onError(Exception ex) {
        LogUtils.logError("onError() : " + ex.getMessage(), ex);
    }

    public boolean isConnected() {
        return isConnected;
    }
}
