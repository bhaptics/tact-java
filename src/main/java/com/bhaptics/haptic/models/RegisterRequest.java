package com.bhaptics.haptic.models;

import com.bhaptics.haptic.models.tact.Project;

public class RegisterRequest {
    private String key;
    private Project project;

    public RegisterRequest(String key, Project project) {
        this.key = key;
        this.project = project;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
