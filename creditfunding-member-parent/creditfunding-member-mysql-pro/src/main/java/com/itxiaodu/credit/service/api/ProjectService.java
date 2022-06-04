package com.itxiaodu.credit.service.api;

import com.itxiaodu.credit.entity.vo.CreditTypeVO;
import com.itxiaodu.credit.entity.vo.DetailProjectVO;
import com.itxiaodu.credit.entity.vo.ProjectVO;
import com.itxiaodu.credit.utils.ResultType;

import java.util.List;

public interface ProjectService {

    ResultType<String> saveProjectVO(ProjectVO projectVO, Integer memberId);

    List<CreditTypeVO> selectCreditTypeVO();

    DetailProjectVO selectDetailProjectVO(Integer id);

}
