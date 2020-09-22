package com.example.testfortkmybatis;

import com.example.testfortkmybatis.domain.Student;
import com.example.testfortkmybatis.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.beans.SimpleBeanInfo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
//@Transactional
//@Rollback
public class TestfortkmybatisApplicationTests {

    @Autowired
    private StudentMapper mapper;

    @Test
    public void insert() throws ParseException {
        Student student = new Student();
        student.setName("vernon");
        String str="1998-02-18";
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sf.parse(str);
        student.setBirth(parse);
        student.setSex("男");
        int insert = mapper.insert(student);
        System.out.println(insert);
    }

    @Test
    public void selectAll(){
        List<Student> students = mapper.selectAll();
        for (Student s:
             students) {
            System.out.println(s.getName());
        }
    }

    @Test
    public void select(){
        Student student = new Student();
        student.setId(1);
        List<Student> students = mapper.select(student);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        for (Student s:
                students) {
            String format = sf.format(s.getBirth());
            System.out.println(format);

        }
    }

}
