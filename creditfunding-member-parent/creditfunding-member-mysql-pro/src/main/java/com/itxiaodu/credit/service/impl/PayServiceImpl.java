package com.itxiaodu.credit.service.impl;

import com.itxiaodu.credit.entity.po.CreditOrderPO;
import com.itxiaodu.credit.entity.po.CreditOrderProjectPO;
import com.itxiaodu.credit.entity.vo.CreditOrderProjectVO;
import com.itxiaodu.credit.entity.vo.CreditOrderVO;
import com.itxiaodu.credit.mapper.CreditOrderPOMapper;
import com.itxiaodu.credit.mapper.CreditOrderProjectPOMapper;
import com.itxiaodu.credit.service.api.PayService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
public class PayServiceImpl implements PayService {
    @Autowired
    private CreditOrderPOMapper creditOrderPOMapper;
    @Autowired
    private CreditOrderProjectPOMapper creditOrderProjectPOMapper;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    @Override
    public void saveCreditVO(CreditOrderVO creditOrderVO) {
        CreditOrderPO creditOrderPO = new CreditOrderPO();
        BeanUtils.copyProperties(creditOrderVO, creditOrderPO);
        creditOrderPOMapper.insert(creditOrderPO);
        CreditOrderProjectPO creditOrderProjectPO = new CreditOrderProjectPO();
        CreditOrderProjectVO creditOrderProjectVO = creditOrderVO.getCreditOrderProjectVO();
        if (creditOrderProjectVO == null) throw new NullPointerException();
        BeanUtils.copyProperties(creditOrderProjectVO, creditOrderProjectPO);
        Integer id=creditOrderPO.getId();
        creditOrderProjectPO.setOrderId(id);
        creditOrderProjectPOMapper.insert(creditOrderProjectPO);
    }
}
