package com.bhaptics.haptic.models;

public class RotationOption {
    private double offsetAngleX;
    private double  offsetY;

    public RotationOption() {
    }

    public RotationOption(double offsetAngleX, double offsetY) {
        this.offsetAngleX = offsetAngleX;
        this.offsetY = offsetY;
    }

    public double getOffsetAngleX() {
        return offsetAngleX;
    }

    public void setOffsetAngleX(double offsetAngleX) {
        this.offsetAngleX = offsetAngleX;
    }

    public double getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(double offsetY) {
        this.offsetY = offsetY;
    }
}
