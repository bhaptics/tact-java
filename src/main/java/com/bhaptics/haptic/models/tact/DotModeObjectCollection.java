package com.bhaptics.haptic.models.tact;

public class DotModeObjectCollection {
    private int StartTime;
    private int EndTime;
    private String PlaybackType;
    private  DotModeObject[] PointList;

    public int getStartTime() {
        return StartTime;
    }

    public void setStartTime(int startTime) {
        StartTime = startTime;
    }

    public int getEndTime() {
        return EndTime;
    }

    public void setEndTime(int endTime) {
        EndTime = endTime;
    }

    public String getPlaybackType() {
        return PlaybackType;
    }

    public void setPlaybackType(String playbackType) {
        PlaybackType = playbackType;
    }

    public DotModeObject[] getPointList() {
        return PointList;
    }

    public void setPointList(DotModeObject[] pointList) {
        PointList = pointList;
    }
}
