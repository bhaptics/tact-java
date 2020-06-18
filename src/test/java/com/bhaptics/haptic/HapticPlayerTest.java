package com.bhaptics.haptic;

import com.bhaptics.haptic.models.*;
import com.bhaptics.haptic.utils.LogUtils;
import com.bhaptics.haptic.utils.StringUtils;
import junit.framework.TestCase;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class HapticPlayerTest extends TestCase {
    private HapticPlayer hapticPlayer;



    @Override
    public void setUp() throws Exception {
        super.setUp();
        LogUtils.log("sdfdsf");
        hapticPlayer = new HapticPlayerImpl("com.bhaptics.sample", "Sample Java App");
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();

        hapticPlayer.dispose();
    }

    private void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void testRegister() {

        // wait for connection
        sleep(1000);

        // register file
        File file = new File(
                getClass().getClassLoader().getResource("Explosion.tact").getFile()
        );

        String content = StringUtils.readFile(file);

        hapticPlayer.register("test", content);



        sleep(2000);

//        hapticPlayer.submitRegistered("test");
//
//        sleep(2000);
//
//        hapticPlayer.submitRegistered("test", "test2",
//                new RotationOption(180, 0),
//                new ScaleOption(1, 1));
//
//        sleep(200);
//        hapticPlayer.turnOff("test2");
//
//        sleep(2000);
//
//        hapticPlayer.submitRegistered("test", "test2",
//                new RotationOption(180, 0.3),
//                new ScaleOption(1, 0.3));
//
//        sleep(5000);


        for (int motorIndex = 0; motorIndex < 20; motorIndex++) {
            List<DotPoint> points =
                    Arrays.asList(new DotPoint(motorIndex, 100));
            hapticPlayer.submitDot("test", PositionType.VestBack, points, 200);
            hapticPlayer.submitDot("test2", PositionType.VestFront, points, 200);

            sleep(300);
        }

        hapticPlayer.submitPath("test2", PositionType.VestFront,
                Arrays.asList(new PathPoint(0.5, 0.5, 100)),
                500);

        sleep(300);
    }
}