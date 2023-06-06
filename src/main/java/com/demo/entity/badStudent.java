package com.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import static com.demo.utils.StudentPatterns.TREAT_BY_STUDENT;
import static com.demo.utils.StudentPatterns.TREAT_BY_TEACHER;

@Data
@EqualsAndHashCode(callSuper = true)
@Component
@Accessors(chain = true)
public class badStudent extends Student implements badStu {

    private String action1;
    private String action2;

    @Override
    public void treatByTeacher() {
        this.action1 = TREAT_BY_TEACHER;
    }

    @Override
    public void treatByStudent() {
        this.action2 = TREAT_BY_STUDENT;
    }
}
