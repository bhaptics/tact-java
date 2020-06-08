package com.bhaptics.haptic.models;

public class ScaleOption {
    private double intensity;
    private double duration;

    public ScaleOption() {
    }

    public ScaleOption(double intensity, double duration) {
        this.intensity = intensity;
        this.duration = duration;
    }

    public double getIntensity() {
        return intensity;
    }

    public void setIntensity(double intensity) {
        this.intensity = intensity;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}
