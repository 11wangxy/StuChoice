package com.demo;

import com.demo.controller.StuController;
import com.demo.service.StudentService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentDTOMapperChoiceApplicationTests {

    @Resource
    private StuController stuController;
    @Resource
    private StudentService studentService;

    @Test
    public void test1() {
        List<String> list = studentService.treatByS();
        System.out.println(list);
    }
}
