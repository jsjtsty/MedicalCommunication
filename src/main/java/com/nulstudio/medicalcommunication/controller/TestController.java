package com.nulstudio.medicalcommunication.controller;

import com.nulstudio.medicalcommunication.entity.TestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;

@Controller
public class TestController {

    static {
        System.load("./lib/libnuldatabridge.so");
    }

    protected native int testJni(int a, int b);

    @RequestMapping("/")
    @ResponseBody
    public TestEntity index(@RequestParam int a, @RequestParam int b) {
        return new TestEntity(String.valueOf(testJni(a, b)));
    }
}
