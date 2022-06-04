package com.itxiaodu.credit.mapper;

import com.itxiaodu.credit.entity.po.ProjectTypePO;
import com.itxiaodu.credit.entity.po.ProjectTypePOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectTypePOMapper {
    long countByExample(ProjectTypePOExample example);

    int deleteByExample(ProjectTypePOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectTypePO record);

    int insertSelective(ProjectTypePO record);

    List<ProjectTypePO> selectByExample(ProjectTypePOExample example);

    ProjectTypePO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectTypePO record, @Param("example") ProjectTypePOExample example);

    int updateByExample(@Param("record") ProjectTypePO record, @Param("example") ProjectTypePOExample example);

    int updateByPrimaryKeySelective(ProjectTypePO record);

    int updateByPrimaryKey(ProjectTypePO record);
}