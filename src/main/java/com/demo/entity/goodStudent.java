package com.demo.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import javax.swing.*;

import static com.demo.utils.StudentPatterns.TREAT_STUDENT;
import static com.demo.utils.StudentPatterns.TREAT_TEACHER;

@Data
@EqualsAndHashCode(callSuper = true)
@Component
@Accessors(chain = true)
public class goodStudent extends Student implements goodStu {

    private String action1;
    private String action2;


    @Override
    public void treatTeacher() {
        this.action1 = TREAT_TEACHER;
    }

    @Override
    public void treatStudent() {
        this.action2 = TREAT_STUDENT;
    }
}
