package com.bhaptics.example;

import com.bhaptics.haptic.HapticPlayer;
import com.bhaptics.haptic.HapticPlayerImpl;
import com.bhaptics.haptic.models.PathPoint;
import com.bhaptics.haptic.models.PositionType;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Sample {
    private static HapticPlayer hapticPlayer = null;

    public static void main(String[] args) {
        hapticPlayer = new HapticPlayerImpl(
                    "com.sample.appId",
                    "Sample Java");

        Thread hapticThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
            hapticPlayer.submitPath("test", PositionType.VestBack, Arrays.asList(new PathPoint(0.5, 0.5, 40)), 1000);

            System.out.println("submitPath");

        });
        hapticThread.setDaemon(true);
        hapticThread.start();




        Scanner scanner = new Scanner(System.in);
        try {
            printInstruction();
            long then = System.currentTimeMillis();
            String line = scanner.nextLine();
            long now = System.currentTimeMillis();
            System.out.printf("Running for %.3fs %n", (now - then) / 1000d);
        } catch(IllegalStateException | NoSuchElementException e) {
            System.out.println("System.in was closed; exiting");
        }
        try {
            hapticThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        hapticPlayer.dispose();
        System.out.println("Program ended.");
    }

    private static void printInstruction() {
        System.out.println("Press Enter to end.");
    }
}
