package com.seawaterbt.ssm.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.seawaterbt.ssm.annotation.MyDataSource;
import com.seawaterbt.ssm.entity.EnglishTeacher;
import com.seawaterbt.ssm.entity.Teacher;
import com.seawaterbt.ssm.enums.DataSourceEnum;
import com.seawaterbt.ssm.multiple.DynamicDataSourceContextHolder;
import com.seawaterbt.ssm.service.EnglishTeacherService;
import com.seawaterbt.ssm.service.TeacherService;
import com.seawaterbt.ssm.vo.TeacherVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("对老师表CRUD")
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    public static final Logger log = LoggerFactory.getLogger(DynamicDataSourceContextHolder.class);

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private EnglishTeacherService englishTeacherService;

    @ApiOperation(value = "添加老师")
    @PostMapping("/add")
    @MyDataSource(DataSourceEnum.DB2)
    @Transactional(rollbackFor = Exception.class)
    public String add(@RequestBody TeacherVo teacher){
        Teacher tea = new Teacher();
        tea.setName(teacher.getName());
        tea.setAge(teacher.getAge());
        tea.setSubject(teacher.getSubject());
        String res = teacherService.save(tea)?"添加成功":"添加失败";
        log.info("res: {}", res);

        EnglishTeacher englishTeacher = new EnglishTeacher();
        englishTeacher.setName(teacher.getName());
        englishTeacher.setAge(teacher.getAge());
        englishTeacher.setSubject(teacher.getSubject());
        String englishRes = englishTeacherService.save(englishTeacher)?"添加成功":"添加失败";
        log.info("englishRes: {}", englishRes);
        int i = 1/0;
        return res;
    }

    @ApiOperation("删除老师")
    @DeleteMapping("/delete/{id}")
    public String delete(@ApiParam("老师的主键id")@PathVariable(value = "id") Integer id){
        return teacherService.removeById(id)?"删除成功":"删除失败";
    }

    @ApiOperation("修改老师")
    @PostMapping("/update")
    public String update(@RequestBody Teacher teacher){
        return teacherService.updateById(teacher)?"修改成功":"修改失败";
    }

    @ApiOperation(value = "查询老师")
    @GetMapping("/list")
    public List<Teacher> list(){
        LambdaQueryWrapper<Teacher> wrapper = new LambdaQueryWrapper<>();
        return teacherService.list(wrapper);
    }
}
