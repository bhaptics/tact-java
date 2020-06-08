package com.bhaptics.haptic.models;

import java.util.List;

public class Frame {
    private int durationMillis;
    private PositionType position;
    private List<PathPoint> pathPoints;
    private List<DotPoint> dotPoints;

    public int getDurationMillis() {
        return durationMillis;
    }

    public void setDurationMillis(int durationMillis) {
        this.durationMillis = durationMillis;
    }

    public PositionType getPosition() {
        return position;
    }

    public void setPosition(PositionType position) {
        this.position = position;
    }

    public List<PathPoint> getPathPoints() {
        return pathPoints;
    }

    public void setPathPoints(List<PathPoint> pathPoints) {
        this.pathPoints = pathPoints;
    }

    public List<DotPoint> getDotPoints() {
        return dotPoints;
    }

    public void setDotPoints(List<DotPoint> dotPoints) {
        this.dotPoints = dotPoints;
    }
}
