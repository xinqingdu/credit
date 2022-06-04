package com.itxiaodu.credit.mapper;

import com.itxiaodu.credit.entity.po.CreditAddressPO;
import com.itxiaodu.credit.entity.po.CreditAddressPOExample;
import com.itxiaodu.credit.entity.vo.CreditAddressVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CreditAddressPOMapper {
    long countByExample(CreditAddressPOExample example);

    int deleteByExample(CreditAddressPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CreditAddressPO record);

    int insertSelective(CreditAddressPO record);

    List<CreditAddressPO> selectByExample(CreditAddressPOExample example);

    CreditAddressPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CreditAddressPO record, @Param("example") CreditAddressPOExample example);

    int updateByExample(@Param("record") CreditAddressPO record, @Param("example") CreditAddressPOExample example);

    int updateByPrimaryKeySelective(CreditAddressPO record);

    int updateByPrimaryKey(CreditAddressPO record);

//    List<CreditAddressVO> selectCreditAddressVO(@Param("memberId") Integer memberId);
}