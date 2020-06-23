package com.bhaptics.haptic.models.tact;

public class DotModeObjectCollection {
    private int startTime;
    private int endTime;
    private String playbackType;
    private  DotModeObject[] pointList;

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public String getPlaybackType() {
        return playbackType;
    }

    public void setPlaybackType(String playbackType) {
        this.playbackType = playbackType;
    }

    public DotModeObject[] getPointList() {
        return pointList;
    }

    public void setPointList(DotModeObject[] pointList) {
        this.pointList = pointList;
    }
}
