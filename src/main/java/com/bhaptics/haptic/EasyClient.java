package com.bhaptics.haptic;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class EasyClient extends WebSocketClient {
    public EasyClient(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        System.out.println("op open");
    }

    @Override
    public void onMessage(String message) {
        System.out.println("received: " + message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("closed");
    }

    @Override
    public void onError(Exception ex) {
        System.out.println("error: " + ex.getMessage());
    }
}
