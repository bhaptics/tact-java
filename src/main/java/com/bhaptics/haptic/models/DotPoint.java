package com.bhaptics.haptic.models;

public class DotPoint {
    private int index;
    private int intensity;

    public DotPoint(int index, int intensity) {
        this.index = index;
        this.intensity = intensity;
    }

    public DotPoint() {
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }
}
