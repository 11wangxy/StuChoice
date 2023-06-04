package com.demo.service.ServiceImpl;

import com.demo.entity.studentDTO;
import com.demo.mapper.StudentMapper;
import com.demo.service.StudentService;
import com.demo.utils.stuChoice;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import static com.demo.utils.StudentPatterns.*;

/**
 * 学生信息处理
 * @author Wang Xiaoyi
 */

@Service
@Slf4j

public class stuServiceImpl implements StudentService {
    private static final String HAVE = "\n共有";
    private static final String STUDENT = "位学生";
    private static final String LISTEN = "听课";
    private static final String BLANK = "  ";
    @Resource
    private stuChoice stuChoice;
    @Resource
    private StudentMapper studentMapper;

    /**
     * 删除原来表中学生信息
     */
    @Override
    public void deleteData() {
        studentMapper.deleteTable();
    }

    /**
     * 根据传递进来的参数count进行生成学生信息插入
     * @param count
     * @return
     */
    @Override
    public String insert(Integer count) {
        long startTime = System.nanoTime();    // 记录开始时间
        List<studentDTO> studentsDto = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            studentDTO stuDto = new studentDTO();
            double random = Math.random();
            if (random < 0.45) {
                BeanUtils.copyProperties(stuChoice.newBadStudent(), stuDto);
                studentsDto.add(stuDto);
            } else {
                BeanUtils.copyProperties(stuChoice.newGoodStudent(), stuDto);
                studentsDto.add(stuDto);
            }
        }
        studentMapper.insertStudent(studentsDto);
        long endTime = System.nanoTime();      // 记录结束时间
        long duration = endTime - startTime;   // 计算程序执行时间，单位为纳秒
        double durationInMs = duration / 1e6;  // 将纳秒转换为毫秒
        return ("新增数据成功，" + "程序执行时间：" + durationInMs + " 毫秒");
    }

    /**
     * 使用一个集合收集学生信息
     * @param list
     * @return
     */
    public List<String> collect(List<studentDTO> list) {
        return list.stream().map(student -> student.getNumber() + BLANK + student.getName() + BLANK + student.getStatus() + BLANK
                + student.getAction1() + BLANK + student.getAction2()).collect(Collectors.toList());
    }

    /**
     * 返回让学生吃饭的叙学生信息
     * @return
     */
    @Override
    public List<String> treatByS() {
        List<String> collect = collect(studentMapper.selectA1(TREAT_BY_STUDENT));
        collect.add(0, HAVE + studentMapper.count1(TREAT_BY_STUDENT) + STUDENT + TREAT_BY_STUDENT);
        return collect;
    }

    /**
     * 返回让老师请吃饭的学生信息
     * @return
     */
    @Override
    public List<String> treatByT() {
        List<String> collect = collect(studentMapper.selectA2(TREAT_BY_TEACHER));
        collect.add(0, HAVE + studentMapper.count2(TREAT_BY_TEACHER) + STUDENT + TREAT_BY_TEACHER);
        return collect;
    }

    /**
     * 返回请学生吃饭的学生信息
     * @return
     */
    @Override
    public List<String> treatS() {
        List<String> collect = collect(studentMapper.selectA1(TREAT_STUDENT));
        collect.add(0, HAVE + studentMapper.count1(TREAT_STUDENT) + STUDENT + TREAT_STUDENT);
        return collect;
    }

    /**
     * 返回让老师请吃饭的学生信息
     * @return
     */
    @Override
    public List<String> treatT() {
        List<String> collect = collect(studentMapper.selectA2(TREAT_TEACHER));
        collect.add(0, HAVE + studentMapper.count2(TREAT_TEACHER) + STUDENT + TREAT_TEACHER);
        return collect;
    }

    /**
     * 返回上课的学生信息
     * @return
     */
    @Override
    public List<String> lacture() {
        List<String> collect = collect(studentMapper.selectS(LISTEN));
        collect.add(0, HAVE + studentMapper.countStatus(LISTEN) + STUDENT + LISTEN);
        return collect;
    }
}

