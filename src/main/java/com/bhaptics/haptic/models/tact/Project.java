package com.bhaptics.haptic.models.tact;

public class Project {
    public Track[] tracks;
    public Layout layout;

    public Track[] getTracks() {
        return tracks;
    }

    public void setTracks(Track[] tracks) {
        this.tracks = tracks;
    }

    public com.bhaptics.haptic.models.tact.Layout getLayout() {
        return layout;
    }

    public void setLayout(com.bhaptics.haptic.models.tact.Layout layout) {
        this.layout = layout;
    }
}

