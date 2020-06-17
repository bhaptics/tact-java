package com.bhaptics.haptic.models.tact;

public class HapticEffectMode {
    private String mode;
    private DotMode dotMode;
    private PathMode pathMode;

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public DotMode getDotMode() {
        return dotMode;
    }

    public void setDotMode(DotMode dotMode) {
        this.dotMode = dotMode;
    }

    public PathMode getPathMode() {
        return pathMode;
    }

    public void setPathMode(PathMode pathMode) {
        this.pathMode = pathMode;
    }
}
