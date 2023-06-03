package com.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

import static com.demo.utils.StudentPatterns.TREAT_BY_STUDENT;
import static com.demo.utils.StudentPatterns.TREAT_BY_TEACHER;

@Data
@EqualsAndHashCode(callSuper = true)
@Component
public class badStudent extends Student implements badStu {

    private String action1;
    private String action2;

    @Override
    public String treatByTeacher() {
        return TREAT_BY_TEACHER;
    }

    @Override
    public String treatByStudent() {
        return TREAT_BY_STUDENT;
    }
}
