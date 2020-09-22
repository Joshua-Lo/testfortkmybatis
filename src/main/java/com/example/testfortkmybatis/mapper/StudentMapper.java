package com.example.testfortkmybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.MyMapper;
import com.example.testfortkmybatis.domain.Student;

@Mapper
public interface StudentMapper extends MyMapper<Student> {
}