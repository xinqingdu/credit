package com.itxiaodu.credit.service.api;

import com.itxiaodu.credit.entity.po.Memberpo;

public interface MemberService {
    public Memberpo getMemberpoByLoginAccount(String loginaccount);

    void saveMember(Memberpo memberpo);
    public boolean isAccountUsed(String loginaccount);
}
