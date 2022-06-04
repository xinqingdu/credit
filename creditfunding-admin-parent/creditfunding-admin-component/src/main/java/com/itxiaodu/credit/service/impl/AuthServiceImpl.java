package com.itxiaodu.credit.service.impl;

import com.itxiaodu.credit.entity.Auth;
import com.itxiaodu.credit.entity.AuthExample;
import com.itxiaodu.credit.mapper.AuthMapper;
import com.itxiaodu.credit.service.inf.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {
    AuthServiceImpl() {

    }

    @Autowired
    private AuthMapper authMapper;

    @Override
    public List<Auth> getAll() {
        List<Auth> authList = authMapper.selectByExample(new AuthExample());
        return authList;
    }

    @Override
    public List<Integer> getAssignedRoleAuth(Integer roleId) {
        return authMapper.selectAssignedRoleAuth(roleId);
    }

    @Override
    public void saveAssignedRoleAuth(Map<String, List<Integer>> map) {
        List<Integer> roleIdList = map.get("roleId");
        Integer roleId = roleIdList.get(0);
        authMapper.deleteAssignedRoleAuth(roleId);
        List<Integer> authIdList = map.get("authIdList");
        if (authIdList != null && authIdList.size() > 0) {
            authMapper.insertAssignedRoleAuth(roleId, authIdList);
        }
    }

    @Override
    public List<String> getAssignedAuthName(Integer adminId) {
        return authMapper.selectAssignedAuthName(adminId);
    }
}
