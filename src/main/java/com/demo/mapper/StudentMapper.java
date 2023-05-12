package com.demo.mapper;

import com.demo.entity.studentDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Delete("delete from test01.student")
    void deleteTable();

    @Insert("insert into test01.student(name,number,status,action1,action2)value(#{name},#{number},#{status},#{action1},#{action2}) ")
    void insertStudent(studentDTO badStu);

    @Select("select * from test01.student where action1 = #{action1}")
    List<studentDTO> selectA1(String action1);

    @Select("select * from test01.student where action2 = #{action2}")
    List<studentDTO> selectA2(String action2);

    @Select("select * from test01.student where status = #{status} ")
    List<studentDTO> selectS(String status);

    @Select("select count(*) from test01.student where action1 = #{action1}")
    Integer count1(String action1);

    @Select("select count(*) from test01.student where action2 = #{action2}")
    Integer count2(String action2);

    @Select("select count(*) from test01.student where status = #{status}")
    Integer countStatus(String status);
}
