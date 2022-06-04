package com.itxiaodu.credit.service.impl;

import com.itxiaodu.credit.entity.po.Memberpo;
import com.itxiaodu.credit.entity.po.MemberpoExample;
import com.itxiaodu.credit.entity.po.MemberpoExample.Criteria;
import com.itxiaodu.credit.mapper.MemberpoMapper;
import com.itxiaodu.credit.service.api.MemberService;
import com.itxiaodu.credit.utils.CreditConstant;
import com.itxiaodu.credit.utils.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class MemberServiceImpl implements MemberService {
    MemberServiceImpl() {

    }
    @Autowired
    private MemberpoMapper memberpoMapper;
    @Transactional(readOnly = true)
    @Override
    public Memberpo getMemberpoByLoginAccount(String loginaccount){
        MemberpoExample example=new MemberpoExample();
        Criteria criteria=example.createCriteria();
        criteria.andLoginAccountEqualTo(loginaccount);
        List<Memberpo> memberpoList=memberpoMapper.selectByExample(example);
        if (memberpoList==null || memberpoList.size()==0) return null;
        return memberpoList.get(0);

    }
    @Override
    public boolean isAccountUsed(String loginaccount){
        if(loginaccount==null) return false;
        Memberpo memberpoByLoginAccount = getMemberpoByLoginAccount(loginaccount);
        return memberpoByLoginAccount!=null;
//        MemberpoExample example=new MemberpoExample();
//        Criteria criteria=example.createCriteria();
//        criteria.andLoginAccountEqualTo(loginaccount);
//        List<Memberpo> memberpoByLoginAccount=memberpoMapper.selectByExample(example);
//        if (memberpoByLoginAccount==null || memberpoByLoginAccount.size()==0) return false;
//        return memberpoByLoginAccount.get(0)!=null;
    }

    @Override
    @Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public void saveMember(Memberpo memberpo) {
        try {
            memberpoMapper.insertSelective(memberpo);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
