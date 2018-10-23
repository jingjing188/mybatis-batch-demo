package com.company.project.modules.mybatisBatch.web;

import com.company.project.modules.mybatisBatch.model.UserInf;
import com.company.project.modules.mybatisBatch.service.UserInfService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @BelongsProject: spring-boot-api-project-seed
 * @BelongsPackage: com.company.project.mybatisBatch.web
 * @Author: lijingrun
 * @CreateTime： 2018/10/18
 * @Version: 1.0.0
 * @Description: todo
 */
@RestController
public class UserInfController {

    @Autowired
    UserInfService userInfService;

    @RequestMapping(value = "test/{size}/{type}")
    public void testInsert(@PathVariable(value = "size") Integer size, @PathVariable(value = "type") Integer type){
        System.out.println(">>>>>>>>>>>>type = " + type + "<<<<<<<<<<<<<");
        switch (type){
            case 1:
                userInfService.testInsertWithForeach(generateList(size));
                break;
            case 2:
                userInfService.testInsertWithXml(generateList(size));
                break;
            case 3:
                userInfService.testInsertWithBatch(generateList(size));
                break;
            default:
                UserInf userInf = new UserInf();
                userInf.setUname("user_single");
                userInf.setGentle("1");
                userInf.setEmail("123@123.com");
                userInf.setCity("广州市");
                userInf.setPasswd("123456");
                userInfService.testInsert(userInf);
        }

    }

    private List<UserInf> generateList(int listSize){
        List<UserInf> list = Lists.newArrayList();

        UserInf userInf = null;
        for (int i = 0; i < listSize; i++) {
            userInf = new UserInf();
            userInf.setUname("user_" + i);
            userInf.setGentle("1");
            userInf.setEmail("123@123.com");
            userInf.setCity("广州市");
            userInf.setPasswd("123456");
            list.add(userInf);
        }

        return list;
    }
}
