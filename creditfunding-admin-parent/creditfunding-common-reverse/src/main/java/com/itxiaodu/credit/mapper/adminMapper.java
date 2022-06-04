package com.itxiaodu.credit.mapper;

import com.itxiaodu.credit.entity.admin;
import com.itxiaodu.credit.entity.adminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface adminMapper {
    long countByExample(adminExample example);

    int deleteByExample(adminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(admin record);

    int insertSelective(admin record);

    List<admin> selectByExample(adminExample example);

    admin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") admin record, @Param("example") adminExample example);

    int updateByExample(@Param("record") admin record, @Param("example") adminExample example);

    int updateByPrimaryKeySelective(admin record);

    int updateByPrimaryKey(admin record);
}