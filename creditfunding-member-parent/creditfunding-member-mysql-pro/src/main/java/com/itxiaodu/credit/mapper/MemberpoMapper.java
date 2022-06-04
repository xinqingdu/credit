package com.itxiaodu.credit.mapper;

import com.itxiaodu.credit.entity.po.Memberpo;
import com.itxiaodu.credit.entity.po.MemberpoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberpoMapper {
    long countByExample(MemberpoExample example);

    int deleteByExample(MemberpoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Memberpo record);

    int insertSelective(Memberpo record);

    List<Memberpo> selectByExample(MemberpoExample example);

    Memberpo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Memberpo record, @Param("example") MemberpoExample example);

    int updateByExample(@Param("record") Memberpo record, @Param("example") MemberpoExample example);

    int updateByPrimaryKeySelective(Memberpo record);

    int updateByPrimaryKey(Memberpo record);
}