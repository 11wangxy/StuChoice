package com.demo;

import com.demo.entity.studentDTO;
import com.demo.mapper.StudentMapper;
import com.demo.service.StudentService;
import com.demo.utils.stuChoice;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.demo.utils.StudentPatterns.STATUS;
import static com.demo.utils.StudentPatterns.TREAT_BY_STUDENT;


@SpringBootTest
public class nameTest {
    @Resource
    private stuChoice stuChoice;
    @Resource
    private StudentService studentService;
    @Resource
    private StudentMapper studentMapper;

    @Test
    public void bs() {
        studentDTO dto = new studentDTO();
        BeanUtils.copyProperties(stuChoice.newBadStudent(), dto);
        List<studentDTO> list = studentMapper.selectS(STATUS);
        System.out.println(list);
    }

    @Test
    public void test1() {
        List<String> list = studentService.treatT();
        System.out.println(list);
    }

    @Test
    public void test2() {
        List<String> list = studentService.treatByS();
        System.out.println(list);
    }
    @Test
    public void test3(){
        List<studentDTO> list = studentMapper.selectA1(TREAT_BY_STUDENT);

    }
}
