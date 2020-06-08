package com.bhaptics.haptic.models;

public class PathPoint {
    private double x;
    private double y;
    private int intensity;

    public PathPoint(double x, double y, int intensity) {
        this.x = x;
        this.y = y;
        this.intensity = intensity;
    }

    public PathPoint(double x) {
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }
}
