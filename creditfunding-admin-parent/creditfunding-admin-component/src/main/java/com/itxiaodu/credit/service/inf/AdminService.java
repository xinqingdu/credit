package com.itxiaodu.credit.service.inf;

import com.github.pagehelper.PageInfo;
import com.itxiaodu.credit.entity.Admin;

import java.util.List;

public interface AdminService {
    public void save(Admin admin);

    public List<Admin> getAll();

    public Admin getLoginAcctAdmin(String loginAcct, String password);

    PageInfo<Admin> getPageInfo(String keyword, Integer pageNum, Integer pageSize);

    void remove(Integer adminId);

    Admin getAdminById(Integer id);

    void update(Admin admin);

    void saveAdminRoleRelationship(Integer adminId, List<Integer> roleIdList);

    Admin getAdminByAcct(String userName);
}
