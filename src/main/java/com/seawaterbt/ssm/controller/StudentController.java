package com.seawaterbt.ssm.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.seawaterbt.ssm.entity.Student;
import com.seawaterbt.ssm.multiple.DynamicDataSourceContextHolder;
import com.seawaterbt.ssm.service.StudentService;
import com.seawaterbt.ssm.vo.StudentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("对学生表CRUD")
@RestController
@RequestMapping("/student")
public class StudentController {
    public static final Logger log = LoggerFactory.getLogger(DynamicDataSourceContextHolder.class);

    @Autowired
    private StudentService studentService;

    @ApiOperation("添加学生")
    @PostMapping("/add")
//    @MyDataSource(DataSourceEnum.DB2)
    @Transactional(rollbackFor = Exception.class)
    public String add(@RequestBody StudentVo student){
        Student stu = new Student();
        stu.setName(student.getName());
        stu.setAge(student.getAge());
        stu.setClassname(student.getClassname());
        String res = studentService.save(stu)?"添加成功":"添加失败";
        log.info(res);
        int i = 1/0;
        return res;
    }

    @ApiOperation("删除学生")
    @DeleteMapping("/delete/{id}")
    public String delete(@ApiParam("学生的主键id")@PathVariable(value = "id") Integer id){
        return studentService.removeById(id)?"删除成功":"删除失败";
    }

    @ApiOperation("修改学生")
    @PostMapping("/update")
    public String update(@RequestBody Student student){
        return studentService.updateById(student)?"修改成功":"修改失败";
    }

    @ApiOperation(value = "查询学生")
    @GetMapping("/list")
    public List<Student> list(){
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        return studentService.list(wrapper);
    }
}
