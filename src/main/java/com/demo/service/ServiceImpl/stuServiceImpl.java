package com.demo.service.ServiceImpl;

import com.demo.entity.studentDTO;
import com.demo.mapper.StudentMapper;
import com.demo.service.StudentService;
import com.demo.utils.stuChoice;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.demo.utils.StudentPatterns.*;


@Service
@Slf4j

public class stuServiceImpl implements StudentService {
    private static final String HAVE = "\n共有";
    private static final String STUDENT = "位学生";
    private static final String LISTEN = "听课";
    @Resource
    private stuChoice stuChoice;
    @Resource
    private StudentMapper studentMapper;

    @Override
    public void deleteData() {
        studentMapper.deleteTable();
    }

    @Override
    public void insert() {
        studentDTO dto = new studentDTO();
        for (int i = 0; i < 20; i++) {
            double random = Math.random();
            if (random < 0.45) {
                BeanUtils.copyProperties(stuChoice.newBadStudent(), dto);
                studentMapper.insertStudent(dto);
            } else {
                BeanUtils.copyProperties(stuChoice.newGoodStudent(), dto);
                studentMapper.insertStudent(dto);
            }
        }
        log.info("插入数据成功");
    }

    public List<String> collect(List<studentDTO> list) {
        return list.stream().map(student -> student.getNumber() + student.getName() + student.getStatus()
                + student.getAction1() + student.getAction2()).collect(Collectors.toList());
    }

    @Override
    public List<String> treatByS() {
        List<String> collect = collect(studentMapper.selectA1(TREAT_BY_STUDENT));
        collect.add(HAVE + studentMapper.count1(TREAT_BY_STUDENT) + STUDENT + TREAT_BY_STUDENT);
        return collect;
    }

    @Override
    public List<String> treatByT() {
        List<String> collect = collect(studentMapper.selectA2(TREAT_BY_TEACHER));
        collect.add(HAVE + studentMapper.count2(TREAT_BY_TEACHER) + STUDENT + TREAT_BY_TEACHER);
        return collect;
    }

    @Override
    public List<String> treatS() {
        List<String> collect = collect(studentMapper.selectA1(TREAT_STUDENT));
        collect.add(HAVE + studentMapper.count1(TREAT_STUDENT) + STUDENT + TREAT_STUDENT);
        return collect;
    }

    @Override
    public List<String> treatT() {
        List<String> collect = collect(studentMapper.selectA1(TREAT_TEACHER));
        collect.add(HAVE + studentMapper.count2(TREAT_TEACHER) + STUDENT + TREAT_TEACHER);
        return collect;
    }

    @Override
    public List<String> lacture() {
        List<String> collect = collect(studentMapper.selectS(LISTEN));
        collect.add(HAVE + studentMapper.countStatus(LISTEN) + STUDENT + LISTEN);
        return collect;
    }

}

