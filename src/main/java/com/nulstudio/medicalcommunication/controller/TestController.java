package com.nulstudio.medicalcommunication.controller;

import com.nulstudio.medicalcommunication.entity.TestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    static {
        System.load("/app/lib/libnuldatabridge.so");
    }

    protected native String nulDataBridgeSendCommunicationString(String input);

    @RequestMapping("/")
    @ResponseBody
    public TestEntity index(@RequestParam String input) {
        return new TestEntity(nulDataBridgeSendCommunicationString(input));
    }
}
