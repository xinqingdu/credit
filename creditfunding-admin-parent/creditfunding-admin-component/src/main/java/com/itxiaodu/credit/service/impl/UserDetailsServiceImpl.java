package com.itxiaodu.credit.service.impl;

import com.itxiaodu.credit.entity.Admin;
import com.itxiaodu.credit.entity.Role;
import com.itxiaodu.credit.mvc.security.SecurityAdmin;
import com.itxiaodu.credit.service.inf.AdminService;
import com.itxiaodu.credit.service.inf.AuthService;
import com.itxiaodu.credit.service.inf.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AdminService adminService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private AuthService authService;
    UserDetailsServiceImpl() {

    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //通过用户名获取用户信息，包括id
        Admin admin = adminService.getAdminByAcct(userName);
        Integer id = admin.getId();
        //通过用户ID获取角色分配信息
        List<Role> assignedRole = roleService.getAssignedRole(id);
        //通过用户id获取权限信息
        List<String> assignedAuthName = authService.getAssignedAuthName(id);

        List<GrantedAuthority> grantedAuthorities=new ArrayList<>();
        //将角色信息存入
        for (Role role:assignedRole){
            String roleName="ROLE_"+role.getName();
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(roleName);
            grantedAuthorities.add(simpleGrantedAuthority);
        }
        //将权限信息存入
        for (String s:assignedAuthName){
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(s);
            grantedAuthorities.add(simpleGrantedAuthority);
        }
        SecurityAdmin securityAdmin = new SecurityAdmin(admin, grantedAuthorities);
        return securityAdmin;
    }
}
