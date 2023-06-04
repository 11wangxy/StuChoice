package com.demo.utils;

import com.demo.entity.Student;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author Wang Xiaoyi
 * 定义一个方法来生成学生的信息
 */
@Component
public class NEWStudent {
    public Student newStudent() {
        String[] firstNames = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "佘", "陈", "褚", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "许", "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章", "云", "苏", "潘", "葛", "奚", "范", "彭",  "鲁", "韦", "昌", "马",  "方", "俞", "任", "袁", "柳"};
        String[] lastNames = {"华", "安", "泽", "林", "明", "毅","彤","易", "武", "冰","华卿", "安娜", "泽娜", "林姗", "明雅", "华鑫", "强波", "易欣", "冰婷", "颖欣"};

        Random random = new Random();
        Student student1 = new Student();

        String firstName = firstNames[random.nextInt(firstNames.length)];
        String lastName = lastNames[random.nextInt(lastNames.length)];
        String name = firstName + lastName;
        student1.setName(name);
        int number = (int) (Math.random() * 100000);
        String id = String.format("212510%05d", number);
        student1.setNumber(id);
        student1.setStatus("听课");
        return student1;
    }
}
