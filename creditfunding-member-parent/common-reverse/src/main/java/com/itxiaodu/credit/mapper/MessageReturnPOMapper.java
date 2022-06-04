package com.itxiaodu.credit.mapper;

import com.itxiaodu.credit.entity.po.MessageReturnPO;
import com.itxiaodu.credit.entity.po.MessageReturnPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageReturnPOMapper {
    long countByExample(MessageReturnPOExample example);

    int deleteByExample(MessageReturnPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MessageReturnPO record);

    int insertSelective(MessageReturnPO record);

    List<MessageReturnPO> selectByExample(MessageReturnPOExample example);

    MessageReturnPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MessageReturnPO record, @Param("example") MessageReturnPOExample example);

    int updateByExample(@Param("record") MessageReturnPO record, @Param("example") MessageReturnPOExample example);

    int updateByPrimaryKeySelective(MessageReturnPO record);

    int updateByPrimaryKey(MessageReturnPO record);
}