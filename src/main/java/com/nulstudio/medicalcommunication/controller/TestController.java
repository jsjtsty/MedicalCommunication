package com.nulstudio.medicalcommunication.controller;

import com.nulstudio.medicalcommunication.entity.TestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Controller
public class TestController {
    @RequestMapping("/")
    @ResponseBody
    public TestEntity index() {
        Process proc;
        StringBuilder s = new StringBuilder();
        try {
            proc = Runtime.getRuntime().exec("python ./src/main/python/CommunicationTest.py");
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                s.append(line).append('\n');
            }
            in.close();
            proc.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return new TestEntity(s.toString());
    }
}
