package com.company.project.modules.mybatisBatch.mapper;

import com.company.project.modules.mybatisBatch.model.UserInf;
import com.company.project.modules.mybatisBatch.model.UserInfExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserInfMapper {
    int countByExample(UserInfExample example);

    int deleteByExample(UserInfExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserInf record);

    int insertWithXMl(@Param("list")List<UserInf> list);

    int insertSelective(UserInf record);

    List<UserInf> selectByExample(UserInfExample example);

    UserInf selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserInf record, @Param("example") UserInfExample example);

    int updateByExample(@Param("record") UserInf record, @Param("example") UserInfExample example);

    int updateByPrimaryKeySelective(UserInf record);

    int updateByPrimaryKey(UserInf record);
}