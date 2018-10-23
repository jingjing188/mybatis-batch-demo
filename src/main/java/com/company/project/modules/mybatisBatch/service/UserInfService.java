package com.company.project.modules.mybatisBatch.service;

import com.company.project.modules.mybatisBatch.model.UserInf;

import java.util.List;

/**
 * @BelongsProject: spring-boot-api-project-seed
 * @BelongsPackage: com.company.project.mybatisBatch.service
 * @Author: lijingrun
 * @CreateTime： 2018/10/18
 * @Version: 1.0.0
 * @Description: todo
 */
public interface UserInfService {

    /**mybatis batch插入*/
    public boolean testInsertWithBatch(List<UserInf> list);

    /**拼接xml插入*/
    public boolean testInsertWithXml(List<UserInf> list);

    /**单条循环插入*/
    public boolean testInsertWithForeach(List<UserInf> list);

    /**单条循环插入*/
    public boolean testInsert(UserInf userInf);

}
