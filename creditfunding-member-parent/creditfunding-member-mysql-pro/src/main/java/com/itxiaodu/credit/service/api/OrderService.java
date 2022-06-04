package com.itxiaodu.credit.service.api;

import com.itxiaodu.credit.entity.vo.CreditAddressVO;
import com.itxiaodu.credit.entity.vo.CreditOrderProjectVO;

import java.util.List;

public interface OrderService {
    CreditOrderProjectVO getCreditOrderProjectVO(Integer projectId,Integer returnId);

    List<CreditAddressVO> getCreditAddressVO(Integer memberId);

    void saveCreditAddressVO(CreditAddressVO creditAddressVO);
}
