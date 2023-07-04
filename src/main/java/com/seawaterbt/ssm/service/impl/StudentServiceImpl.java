package com.seawaterbt.ssm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seawaterbt.ssm.entity.Student;
import com.seawaterbt.ssm.mapper.StudentMapper;
import com.seawaterbt.ssm.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper,Student> implements StudentService {

    public static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);

//    @Transactional(rollbackFor = Exception.class)
//    public boolean save(Student entity) {
//        log.info("进入事务");
//        int count = baseMapper.insert(entity);
//        log.info("count={}", count);
//        int i = 1/0;
//        return retBool(count);
//    }

}
