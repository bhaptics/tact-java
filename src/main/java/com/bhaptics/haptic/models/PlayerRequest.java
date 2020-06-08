package com.bhaptics.haptic.models;

import java.util.ArrayList;
import java.util.List;

public class PlayerRequest {
    public List<RegisterRequest> register;
    public List<SubmitRequest> submit;

    public PlayerRequest() {
        register = new ArrayList<>();
        submit = new ArrayList<>();
    }

    public void addRegister(RegisterRequest registerRequest) {
        register.add(registerRequest);
    }

    public void addSubmit(SubmitRequest submitRequest) {
        submit.add(submitRequest);
    }

    public List<RegisterRequest> getRegister() {
        return register;
    }

    public List<SubmitRequest> getSubmit() {
        return submit;
    }
}
