package com.company.project.modules.mybatisBatch.service;

import com.company.project.modules.mybatisBatch.mapper.UserInfMapper;
import com.company.project.modules.mybatisBatch.model.UserInf;
import com.google.common.collect.Lists;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @BelongsProject: spring-boot-api-project-seed
 * @BelongsPackage: com.company.project.mybatisBatch.service
 * @Author: lijingrun
 * @CreateTime： 2018/10/18
 * @Version: 1.0.0
 * @Description: todo
 */
@Service
public class UserInfServiceImpl implements UserInfService{
    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfServiceImpl.class);

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Autowired
    UserInfMapper userInfMapper;

    @Transactional
    @Override
    public boolean testInsertWithBatch(List<UserInf> list) {
        LOGGER.info(">>>>>>>>>>>testInsertWithBatch start<<<<<<<<<<<<<<");
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH,false);
        UserInfMapper mapper = sqlSession.getMapper(UserInfMapper.class);

        long startTime = System.nanoTime();

        try {
            List<UserInf> userInfs = Lists.newArrayList();
            for (int i = 0; i < 10000; i++) {
                if (i%1000 == 999){
                    sqlSession.commit();
                    sqlSession.clearCache();
                }
                mapper.insert(list.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        LOGGER.info("testInsertWithBatch spend time:{}",System.nanoTime()-startTime);
        LOGGER.info(">>>>>>>>>>>testInsertWithBatch end<<<<<<<<<<<<<<");

        return true;
    }

    @Transactional
    @Override
    public boolean testInsertWithXml(List<UserInf> list) {
        LOGGER.info(">>>>>>>>>>>testInsertWithXml start<<<<<<<<<<<<<<");
        long startTime = System.nanoTime();

        userInfMapper.insertWithXMl(list);

        LOGGER.info("testInsertWithXml spend time:{}",System.nanoTime()-startTime);
        LOGGER.info(">>>>>>>>>>>testInsertWithXml end<<<<<<<<<<<<<<");
        return true;
    }

    @Transactional
    @Override
    public boolean testInsertWithForeach(List<UserInf> list) {
        LOGGER.info(">>>>>>>>>>>testInsertWithForeach start<<<<<<<<<<<<<<");
        long startTime = System.nanoTime();

        for (int i = 0; i < list.size(); i++) {
            userInfMapper.insert(list.get(i));
        }
        LOGGER.info("testInsertWithForeach spend time:{}",System.nanoTime()-startTime);
        LOGGER.info(">>>>>>>>>>>testInsertWithForeach end<<<<<<<<<<<<<<");

        return true;
    }

    @Transactional
    @Override
    public boolean testInsert(UserInf userInf) {
        LOGGER.info(">>>>>>>>>>>testInsert start<<<<<<<<<<<<<<");
        long startTime = System.nanoTime();

        userInfMapper.insert(userInf);
        LOGGER.info("testInsert spend time:{}",System.nanoTime()-startTime);
        LOGGER.info(">>>>>>>>>>>testInsert end<<<<<<<<<<<<<<");

        return true;
    }
}
