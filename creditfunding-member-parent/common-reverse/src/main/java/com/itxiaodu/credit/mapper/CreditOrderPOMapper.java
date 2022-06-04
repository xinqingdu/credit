package com.itxiaodu.credit.mapper;

import com.itxiaodu.credit.entity.po.CreditOrderPO;
import com.itxiaodu.credit.entity.po.CreditOrderPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CreditOrderPOMapper {
    long countByExample(CreditOrderPOExample example);

    int deleteByExample(CreditOrderPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CreditOrderPO record);

    int insertSelective(CreditOrderPO record);

    List<CreditOrderPO> selectByExample(CreditOrderPOExample example);

    CreditOrderPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CreditOrderPO record, @Param("example") CreditOrderPOExample example);

    int updateByExample(@Param("record") CreditOrderPO record, @Param("example") CreditOrderPOExample example);

    int updateByPrimaryKeySelective(CreditOrderPO record);

    int updateByPrimaryKey(CreditOrderPO record);
}