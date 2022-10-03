package com.nulstudio.medicalcommunication.controller;

import com.nulstudio.medicalcommunication.entity.TestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @RequestMapping("/")
    @ResponseBody
    public TestEntity index() {
        return new TestEntity(System.getProperty("user.dir"));
    }
}
