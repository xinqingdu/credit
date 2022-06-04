package com.itxiaodu.credit.service.inf;

import com.github.pagehelper.PageInfo;
import com.itxiaodu.credit.entity.Role;

import java.util.List;

public interface RoleService {
    PageInfo<Role> getPageInfo(Integer pageNum, Integer pageSize,String keyword);

    void save(Role role);

    void update(Role role);

    void removeRole(List<Integer> roleIdList);

    List<Role> getAssignedRole(Integer adminId);

    List<Role> getUnassignedRole(Integer adminId);
}
