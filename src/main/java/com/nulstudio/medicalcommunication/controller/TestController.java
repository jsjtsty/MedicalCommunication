package com.nulstudio.medicalcommunication.controller;

import com.nulstudio.medicalcommunication.entity.TestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;

@Controller
public class TestController {
    @RequestMapping("/")
    @ResponseBody
    public TestEntity index() {
        final String fileName = "./src/main/python/CommunicationTest.py";
        StringBuilder s = new StringBuilder();
        /*
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                s.append("line ").append(line).append(": ").append(tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        */
        Process proc;
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
