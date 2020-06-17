package com.bhaptics.haptic;

import com.bhaptics.haptic.models.*;

import java.util.List;

public interface HapticPlayer {
    void dispose();

    boolean isPlaying(String key);
    boolean isPlaying();
    void register(String key, String projectContentStr);

    void submitPath(String key, PositionType positionType, List<PathPoint> points, int durationMillis);
    void submitDot(String key, PositionType positionType, List<DotPoint> points, int durationMillis);

    void submitRegistered(String key);
    void submitRegistered(String key, String altKey, RotationOption rotationOption, ScaleOption scaleOption);

    void turnOff(String key);
    void turnOff();
}
