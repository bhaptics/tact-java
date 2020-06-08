package com.bhaptics.haptic.models;

public class RegisterRequest {
    private String key;
    private Object project;

    public RegisterRequest(String key, Object project) {
        this.key = key;
        this.project = project;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getProject() {
        return project;
    }

    public void setProject(Object project) {
        this.project = project;
    }
}
