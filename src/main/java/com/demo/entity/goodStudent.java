package com.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

import static com.demo.utils.StudentPatterns.TREAT_STUDENT;
import static com.demo.utils.StudentPatterns.TREAT_TEACHER;

@Data
@EqualsAndHashCode(callSuper = true)
@Component
public class goodStudent extends Student implements goodStu {

    private String action1;
    private String action2;

    @Override
    public String treatTeacher() {
        return TREAT_TEACHER;
    }

    @Override
    public String treatStudent() {
        return TREAT_STUDENT;
    }
}
