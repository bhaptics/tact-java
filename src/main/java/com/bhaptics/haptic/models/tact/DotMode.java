package com.bhaptics.haptic.models.tact;

public class DotMode {
    private boolean dotConnected;
    private DotModeObjectCollection[] feedback;

    public boolean isDotConnected() {
        return dotConnected;
    }

    public void setDotConnected(boolean dotConnected) {
        this.dotConnected = dotConnected;
    }

    public DotModeObjectCollection[] getFeedback() {
        return feedback;
    }

    public void setFeedback(DotModeObjectCollection[] feedback) {
        this.feedback = feedback;
    }
}
