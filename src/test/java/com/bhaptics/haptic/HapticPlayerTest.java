package com.bhaptics.haptic;

import com.bhaptics.haptic.utils.LogUtils;
import com.bhaptics.haptic.utils.StringUtils;
import com.google.gson.Gson;
import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;

public class HapticPlayerTest extends TestCase {
    private HapticPlayer hapticPlayer;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        hapticPlayer = new HapticPlayerImpl("com.bhaptics.sample", "Sample App");
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();

        hapticPlayer.dispose();
    }

    public void testRegister() {
        File file = new File(
                getClass().getClassLoader().getResource("Explosion.tact").getFile()
        );

        String content = StringUtils.readFile(file);


        Gson gson = new Gson();

        Map<String, Object> o = gson.fromJson(content, Map.class);

        Object project = o.get("project");

        LogUtils.log(project.toString());


        try {
            Thread.sleep(2000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        hapticPlayer.register("test", content);



        try {
            Thread.sleep(2000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        hapticPlayer.submitRegistered("test");

        try {
            Thread.sleep(2000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}