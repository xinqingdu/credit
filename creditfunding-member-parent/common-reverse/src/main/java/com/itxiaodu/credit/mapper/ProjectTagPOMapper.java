package com.itxiaodu.credit.mapper;

import com.itxiaodu.credit.entity.po.ProjectTagPO;
import com.itxiaodu.credit.entity.po.ProjectTagPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectTagPOMapper {
    long countByExample(ProjectTagPOExample example);

    int deleteByExample(ProjectTagPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectTagPO record);

    int insertSelective(ProjectTagPO record);

    List<ProjectTagPO> selectByExample(ProjectTagPOExample example);

    ProjectTagPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectTagPO record, @Param("example") ProjectTagPOExample example);

    int updateByExample(@Param("record") ProjectTagPO record, @Param("example") ProjectTagPOExample example);

    int updateByPrimaryKeySelective(ProjectTagPO record);

    int updateByPrimaryKey(ProjectTagPO record);
}