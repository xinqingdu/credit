package com.itxiaodu.credit.mapper;

import com.itxiaodu.credit.entity.po.CreditOrderProjectPO;
import com.itxiaodu.credit.entity.po.CreditOrderProjectPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CreditOrderProjectPOMapper {
    long countByExample(CreditOrderProjectPOExample example);

    int deleteByExample(CreditOrderProjectPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CreditOrderProjectPO record);

    int insertSelective(CreditOrderProjectPO record);

    List<CreditOrderProjectPO> selectByExample(CreditOrderProjectPOExample example);

    CreditOrderProjectPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CreditOrderProjectPO record, @Param("example") CreditOrderProjectPOExample example);

    int updateByExample(@Param("record") CreditOrderProjectPO record, @Param("example") CreditOrderProjectPOExample example);

    int updateByPrimaryKeySelective(CreditOrderProjectPO record);

    int updateByPrimaryKey(CreditOrderProjectPO record);
}