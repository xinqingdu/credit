package com.itxiaodu.credit.mapper;

import com.itxiaodu.credit.entity.po.ProjectMemberInfoPO;
import com.itxiaodu.credit.entity.po.ProjectMemberInfoPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectMemberInfoPOMapper {
    long countByExample(ProjectMemberInfoPOExample example);

    int deleteByExample(ProjectMemberInfoPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectMemberInfoPO record);

    int insertSelective(ProjectMemberInfoPO record);

    List<ProjectMemberInfoPO> selectByExample(ProjectMemberInfoPOExample example);

    ProjectMemberInfoPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectMemberInfoPO record, @Param("example") ProjectMemberInfoPOExample example);

    int updateByExample(@Param("record") ProjectMemberInfoPO record, @Param("example") ProjectMemberInfoPOExample example);

    int updateByPrimaryKeySelective(ProjectMemberInfoPO record);

    int updateByPrimaryKey(ProjectMemberInfoPO record);
}