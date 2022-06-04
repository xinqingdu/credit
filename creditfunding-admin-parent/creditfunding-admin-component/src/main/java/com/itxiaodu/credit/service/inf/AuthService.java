package com.itxiaodu.credit.service.inf;

import com.itxiaodu.credit.entity.Auth;

import java.util.List;
import java.util.Map;

public interface AuthService {
    List<Auth> getAll();

    List<Integer> getAssignedRoleAuth(Integer roleId);

    void saveAssignedRoleAuth(Map<String, List<Integer>> map);

    List<String> getAssignedAuthName(Integer adminId);
}
