package com.bhaptics.haptic;

import com.bhaptics.haptic.models.*;

public interface HapticPlayer {
    void dispose();

    boolean isPlaying(String key);
    boolean isPlaying();
    void register(String key, String projectContentStr);


    void submit(String key, PositionType positionType, byte[] motorBytes, int durationMillis);
    void submit(String key, PositionType positionType, PathPoint[] points, int durationMillis);
    void submit(String key, PositionType positionType, DotPoint[] points, int durationMillis);

    void submitRegistered(String key);
    void submitRegistered(String key, String altKey, RotationOption rotationOption, ScaleOption scaleOption);

    void turnOff(String key);
    void turnOff();
}
