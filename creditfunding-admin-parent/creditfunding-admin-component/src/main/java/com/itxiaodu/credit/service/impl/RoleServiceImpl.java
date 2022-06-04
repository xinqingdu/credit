package com.itxiaodu.credit.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itxiaodu.credit.entity.Role;
import com.itxiaodu.credit.entity.RoleExample;
import com.itxiaodu.credit.mapper.RoleMapper;
import com.itxiaodu.credit.service.inf.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    RoleServiceImpl() {

    }
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public PageInfo<Role> getPageInfo(Integer pageNum, Integer pageSize,String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        List<Role> roles = roleMapper.selectByKey(keyword);
        return new PageInfo<>(roles);
    }

    @Override
    public void save(Role role) {
        roleMapper.insert(role);
    }

    @Override
    public void update(Role role) {
        roleMapper.updateByPrimaryKey(role);
    }

    @Override
    public void removeRole(List<Integer> roleIdList) {
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        //delete from role where id in (...);
        criteria.andIdIn(roleIdList);
        roleMapper.deleteByExample(roleExample);
    }

    @Override
    public List<Role> getAssignedRole(Integer adminId) {
        List<Role> roles = roleMapper.selectAssignedRole(adminId);
        return roles;
    }

    @Override
    public List<Role> getUnassignedRole(Integer adminId) {
        List<Role> roles = roleMapper.selectUnassignedRole(adminId);
        return roles;
    }
}
