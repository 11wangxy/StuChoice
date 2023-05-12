package com.demo.utils;

import com.demo.entity.Student;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NEWStudent {
    public Student newStudent() {
        String[] firstNames = {"张", "王", "李", "赵", "周", "钱", "孙", "吴", "郑", "陈", "楚", "魏", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许"};
        String[] lastNames = {"三", "四", "五", "六", "七", "八", "九", "十", "华", "安", "泽", "林", "明", "华", "军", "强", "利", "易", "武", "冰"};

        Random random = new Random();
        Student student1 = new Student();

        String firstName = firstNames[random.nextInt(firstNames.length)];
        String lastName = lastNames[random.nextInt(lastNames.length)];
        String name = firstName + lastName;
        student1.setName(name);
        int number = (int) (Math.random() * 1000);
        String id = String.format("21251008%03d", number);
        student1.setNumber(id);
        student1.setStatus("听课");
        return student1;
    }
}
