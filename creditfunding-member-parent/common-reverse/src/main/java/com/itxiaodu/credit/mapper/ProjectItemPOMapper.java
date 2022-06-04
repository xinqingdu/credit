package com.itxiaodu.credit.mapper;

import com.itxiaodu.credit.entity.po.ProjectItemPO;
import com.itxiaodu.credit.entity.po.ProjectItemPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectItemPOMapper {
    long countByExample(ProjectItemPOExample example);

    int deleteByExample(ProjectItemPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectItemPO record);

    int insertSelective(ProjectItemPO record);

    List<ProjectItemPO> selectByExample(ProjectItemPOExample example);

    ProjectItemPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectItemPO record, @Param("example") ProjectItemPOExample example);

    int updateByExample(@Param("record") ProjectItemPO record, @Param("example") ProjectItemPOExample example);

    int updateByPrimaryKeySelective(ProjectItemPO record);

    int updateByPrimaryKey(ProjectItemPO record);
}