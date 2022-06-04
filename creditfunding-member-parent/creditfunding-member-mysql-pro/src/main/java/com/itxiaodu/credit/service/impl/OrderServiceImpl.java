package com.itxiaodu.credit.service.impl;

import com.itxiaodu.credit.entity.po.CreditAddressPO;
import com.itxiaodu.credit.entity.po.CreditAddressPOExample;
import com.itxiaodu.credit.entity.vo.CreditAddressVO;
import com.itxiaodu.credit.entity.vo.CreditOrderProjectVO;
import com.itxiaodu.credit.mapper.CreditAddressPOMapper;
import com.itxiaodu.credit.mapper.CreditOrderPOMapper;
import com.itxiaodu.credit.mapper.CreditOrderProjectPOMapper;
import com.itxiaodu.credit.service.api.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional(readOnly = true)
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private CreditOrderProjectPOMapper creditOrderProjectPOMapper;
    @Autowired
    private CreditAddressPOMapper creditAddressPOMapper;

    @Autowired
    private CreditOrderPOMapper creditOrderPOMapper;

    @Override
    public CreditOrderProjectVO getCreditOrderProjectVO(Integer projectId, Integer returnId) {
        CreditOrderProjectVO creditOrderProjectVO = creditOrderProjectPOMapper.selectOrderProjectVO(projectId, returnId);
        return creditOrderProjectVO;
    }

    @Override
    public List<CreditAddressVO> getCreditAddressVO(Integer memberId) {
        CreditAddressPOExample creditAddressPOExample = new CreditAddressPOExample();
        creditAddressPOExample.createCriteria().andMemberIdEqualTo(memberId);
        List<CreditAddressPO> creditAddressPOList = creditAddressPOMapper.selectByExample(creditAddressPOExample);
        List<CreditAddressVO> creditAddressVOList = new ArrayList<>();
        for (CreditAddressPO creditAddressPO : creditAddressPOList) {
            CreditAddressVO creditAddressVO = new CreditAddressVO();
            BeanUtils.copyProperties(creditAddressPO, creditAddressVO);
            creditAddressVOList.add(creditAddressVO);
        }
        return creditAddressVOList;
    }
    @Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    @Override
    public void saveCreditAddressVO(CreditAddressVO creditAddressVO) {
        CreditAddressPO creditAddressPO = new CreditAddressPO();
        BeanUtils.copyProperties(creditAddressVO,creditAddressPO);
        creditAddressPOMapper.insert(creditAddressPO);
    }
}
