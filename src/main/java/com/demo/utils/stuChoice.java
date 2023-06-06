package com.demo.utils;

import com.demo.entity.Student;
import com.demo.entity.badStudent;
import com.demo.entity.goodStudent;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author Wang Xiaoyi
 * 定义学生的选择
 */
@Component
@Slf4j
public class stuChoice {
    @Resource
    private NEWStudent newStudent;
    @Resource
    private badStudent badStudent;
    @Resource
    private goodStudent goodStudent;

    public badStudent newBadStudent() {
        Student student = newStudent.newStudent();
        BeanUtils.copyProperties(student, badStudent);
        double random1 = Math.random();
        double random2 = Math.random();
        badStudent.setAction2("").setAction1("");
        if (random1 <= 0.3) {
            badStudent.treatByStudent();
        }
        if (random1 > 0.5 && random1 <= 0.8) {
            badStudent.treatByTeacher();
        }
        if (random1 > 0.8) {
            badStudent.treatByStudent();
            badStudent.treatByTeacher();
        }
        if (random2 > 0.5) {
            badStudent.setStatus("不听课");
        }
        return badStudent;
    }

    public goodStudent newGoodStudent() {
        Student student = newStudent.newStudent();
        BeanUtils.copyProperties(student, goodStudent);
        double random1 = Math.random();
        double random2 = Math.random();
        goodStudent.setAction2(" ").setAction1("");
        if (random1 <= 0.5) {
            goodStudent.setAction2(" ");
            goodStudent.treatStudent();
        }
        if (random1 > 0.5 && random1 <= 0.8) {
            goodStudent.setAction1(" ");
            goodStudent.treatTeacher();
        }
        if (random1 > 0.8) {
            goodStudent.treatTeacher();
            goodStudent.treatStudent();
        }
        if (random2 > 0.85) {
            badStudent.setStatus("不听课");
        }
        return goodStudent;
    }
}


