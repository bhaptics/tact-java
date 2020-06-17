package com.bhaptics.haptic.models.tact;

import java.util.Map;

public class HapticEffect {
    private int startTime;
    private int offsetTime;
    private Map<String, HapticEffectMode> modes;

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getOffsetTime() {
        return offsetTime;
    }

    public void setOffsetTime(int offsetTime) {
        this.offsetTime = offsetTime;
    }

    public Map<String, HapticEffectMode> getModes() {
        return modes;
    }

    public void setModes(Map<String, HapticEffectMode> modes) {
        this.modes = modes;
    }
}
