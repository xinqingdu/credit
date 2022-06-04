package com.itxiaodu.credit.mvc.security;

import com.itxiaodu.credit.entity.Admin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public class SecurityAdmin extends User {
    private static final long serialVersionUID = 1L;

    private Admin admin;
    public SecurityAdmin(Admin admin, List<GrantedAuthority> grantedAuthorities){
        super(admin.getLoginAccount(),admin.getUserPassword(),grantedAuthorities);
        this.admin=admin;
        admin.setUserPassword(null);
    }

    public Admin getAdmin() {
        return admin;
    }

}
