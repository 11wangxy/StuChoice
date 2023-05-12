package com.demo.utils;

import com.demo.entity.Student;
import com.demo.entity.badStudent;
import com.demo.entity.goodStudent;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

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
        BeanUtils.copyProperties(student, badStudent); // 将student的属性复制到badStu中
        double random1 = Math.random();
        double random2 = Math.random();
        if (random1 <= 0.45) {
            badStudent.setAction1(badStudent.treatByStudent());
        }
        if (random1 > 0.45 && random1 <= 0.8) {
            badStudent.setAction2(badStudent.treatByTeacher());
        }
        if (random1 > 0.8) {
            badStudent.setAction1(badStudent.treatByStudent());
            badStudent.setAction2(badStudent.treatByTeacher());
        }
        if (random2 > 0.4) {
            badStudent.setStatus("不听课");
        }
        return badStudent;
    }

    public goodStudent newGoodStudent() {
        Student student = newStudent.newStudent();
        BeanUtils.copyProperties(student, goodStudent);
        double random1 = Math.random();
        double random2 = Math.random();
        if (random1 <= 0.5) {
            goodStudent.setAction1(goodStudent.treatStudent());
        }
        if (random1 > 0.5 && random1 <= 0.8) {
            goodStudent.setAction2(goodStudent.treatTeacher());
        }
        if (random1 > 0.8) {
            goodStudent.setAction2(goodStudent.treatTeacher());
            goodStudent.setAction1(goodStudent.treatStudent());
        }
        if (random2 > 0.8) {
            badStudent.setStatus("不听课");
        }
        return goodStudent;
    }
}


