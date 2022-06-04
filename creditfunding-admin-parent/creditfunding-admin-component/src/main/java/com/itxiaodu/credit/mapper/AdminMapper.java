package com.itxiaodu.credit.mapper;

import com.itxiaodu.credit.entity.Admin;
import com.itxiaodu.credit.entity.AdminExample;
import com.itxiaodu.credit.entity.Admin;
import com.itxiaodu.credit.entity.AdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    long countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    List<Admin> selectByKey(String keyword);

    void deleteRelationship(Integer adminId);

    void insertRelationship(@Param("adminId") Integer adminId,@Param("roleIdList") List<Integer> roleIdList);
}