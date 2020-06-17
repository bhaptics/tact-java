package com.bhaptics.haptic.models.tact;

public class PathModeObjectCollection {
    private String playbackType;
    private String movingPattern;
    private PathModeObject[] pointList;

    public String getPlaybackType() {
        return playbackType;
    }

    public void setPlaybackType(String playbackType) {
        this.playbackType = playbackType;
    }

    public String getMovingPattern() {
        return movingPattern;
    }

    public void setMovingPattern(String movingPattern) {
        this.movingPattern = movingPattern;
    }

    public PathModeObject[] getPointList() {
        return pointList;
    }

    public void setPointList(PathModeObject[] pointList) {
        this.pointList = pointList;
    }
}
