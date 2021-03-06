package com.bhaptics.haptic;

import com.bhaptics.haptic.models.*;
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
        String appId = "com.bhaptics.sample";
        String appName = "Sample Java App";
        hapticPlayer = new HapticPlayerImpl(appId, appName, true, (connected) -> {
            System.out.println("connected =========== " + connected);

            if (connected) {
                registerFiles();
                System.out.println("registerFiles()");
            }

        });
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

    private void registerFiles() {
        List<String> files = Arrays.asList(
                "Explosion",
                "skelettonArrow",
                "skelettonArrowSmallFront",
                "Explosion2",
                "ArrowHit2");

        for (String fileName : files) {
            File file = new File(
                    getClass().getClassLoader().getResource(fileName + ".tact").getFile()
            );

            String content = StringUtils.readFile(file);

            hapticPlayer.register(fileName, content);
        }
    }

    public void testRegister() {

        // wait for connection
        sleep(1000);


        System.out.println("skelettonArrowSmallFront");

        hapticPlayer.submitRegistered("skelettonArrowSmallFront");

        sleep(2000);

        System.out.println("skelettonArrow");
        hapticPlayer.submitRegistered("skelettonArrow");

        sleep(2000);

        System.out.println("Explosion");
        hapticPlayer.submitRegistered("Explosion");

        sleep(2000);

        hapticPlayer.submitRegistered("Explosion", "test2",
                new RotationOption(180, 0),
                new ScaleOption(1, 1));

        sleep(200);
        System.out.println("test2");
        hapticPlayer.turnOff("test2");

        sleep(2000);

        hapticPlayer.submitRegistered("ArrowHit2", "test2",
                new RotationOption(180, 0.3),
                new ScaleOption(1, 0.3));

        sleep(5000);


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