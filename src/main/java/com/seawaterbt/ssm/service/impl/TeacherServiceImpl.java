package com.seawaterbt.ssm.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seawaterbt.ssm.annotation.MyDataSource;
import com.seawaterbt.ssm.entity.Teacher;
import com.seawaterbt.ssm.enums.DataSourceEnum;
import com.seawaterbt.ssm.mapper.TeacherMapper;
import com.seawaterbt.ssm.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper,Teacher> implements TeacherService {
    public static final Logger log = LoggerFactory.getLogger(TeacherServiceImpl.class);

    @Override
    @MyDataSource(DataSourceEnum.DB2)
    @Transactional(rollbackFor = Exception.class)
    public boolean save(Teacher entity) {
//        return saveEntity(entity);

        log.info("进入事务");
        int count = baseMapper.insert(entity);
        log.info("count={}", count);
//        int i = 1/0;
        return retBool(count);
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean saveEntity(Teacher entity){
        log.info("进入事务");
        int count = baseMapper.insert(entity);
        log.info("count={}", count);
        int i = 1/0;
        return retBool(count);
    }

    @Override
    @MyDataSource(DataSourceEnum.DB2)
    public boolean removeById(Serializable id) {
        return retBool(baseMapper.deleteById(id));
    }

    public boolean retBool(Integer result) {
        return null != result && result >= 1;
    }

    @Override
    @MyDataSource(DataSourceEnum.DB2)
    public boolean updateById(Teacher entity) {
        return retBool(baseMapper.updateById(entity));
    }

    @Override
    @MyDataSource(DataSourceEnum.DB2)
    public List<Teacher> list(Wrapper<Teacher> wrapper) {
        return baseMapper.selectList(wrapper);
    }

}
