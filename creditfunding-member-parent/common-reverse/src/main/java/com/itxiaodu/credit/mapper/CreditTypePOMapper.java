package com.itxiaodu.credit.mapper;

import com.itxiaodu.credit.entity.po.CreditTypePO;
import com.itxiaodu.credit.entity.po.CreditTypePOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CreditTypePOMapper {
    long countByExample(CreditTypePOExample example);

    int deleteByExample(CreditTypePOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CreditTypePO record);

    int insertSelective(CreditTypePO record);

    List<CreditTypePO> selectByExample(CreditTypePOExample example);

    CreditTypePO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CreditTypePO record, @Param("example") CreditTypePOExample example);

    int updateByExample(@Param("record") CreditTypePO record, @Param("example") CreditTypePOExample example);

    int updateByPrimaryKeySelective(CreditTypePO record);

    int updateByPrimaryKey(CreditTypePO record);
}