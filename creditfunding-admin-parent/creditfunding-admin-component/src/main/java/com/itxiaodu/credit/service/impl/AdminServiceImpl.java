package com.itxiaodu.credit.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itxiaodu.credit.constant.CreditConstant;
import com.itxiaodu.credit.entity.Admin;
import com.itxiaodu.credit.entity.AdminExample;
import com.itxiaodu.credit.exception.AccountExistException;
import com.itxiaodu.credit.exception.LoginFailedException;
import com.itxiaodu.credit.mapper.AdminMapper;
import com.itxiaodu.credit.service.inf.AdminService;
import com.itxiaodu.credit.util.JudgeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class AdminServiceImpl implements AdminService {
    AdminServiceImpl() {

    }

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Admin admin) {




        String userPassword = admin.getUserPassword();
//        userPassword = JudgeUtil.md5Password(userPassword);
        userPassword=bCryptPasswordEncoder.encode(userPassword);
        admin.setUserPassword(userPassword);
        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String createTime = simpleDateFormat.format(date);
        admin.setCreateTime(date);
        try {
            adminMapper.insert(admin);
        }catch (Exception e){
            if(e instanceof DuplicateKeyException){
                throw new AccountExistException(CreditConstant.CONST_MESSAGE_ACCOUNT_IN_USE);
            }
        }
    }

    @Override
    public List<Admin> getAll() {
        return adminMapper.selectByExample(new AdminExample());
    }

    @Override
    public Admin getLoginAcctAdmin(String loginAcct, String password) {
        //根据账号查询Admin对象
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andLoginAccountEqualTo(loginAcct);
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if (password == null || password.length() == 0 || admins == null || admins.size() == 0 || admins.get(0) == null) {
            throw new LoginFailedException(CreditConstant.CONST_MESSAGE_LOGIN_FAILED);
        }
        if (admins.size() > 1) {
            throw new RuntimeException(CreditConstant.CONST_MESSAGE_LOGIN_NO_UNIQUE);
        }
        //如果存在Admin则将表单密码加密
        Admin admin = admins.get(0);
        String userPassword = admin.getUserPassword();
        String passwordMd5 = JudgeUtil.md5Password(password);
        //比较查询的密码
        if (!Objects.equals(userPassword, passwordMd5)) {
            throw new LoginFailedException(CreditConstant.CONST_MESSAGE_LOGIN_FAILED);
        }
        //一致则返回Admin对象
        return admin;
    }

    @Override
    public PageInfo<Admin> getPageInfo(String keyword, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        List<Admin> admins = adminMapper.selectByKey(keyword);
        return new PageInfo<>(admins);
    }

    @Override
    public void remove(Integer adminId) {
        adminMapper.deleteByPrimaryKey(adminId);
    }

    @Override
    public Admin getAdminById(Integer id) {
        Admin admin = adminMapper.selectByPrimaryKey(id);
        assert admin!=null;
        return admin;
    }

    @Override
    public void update(Admin admin) {
        try {
            adminMapper.updateByPrimaryKeySelective(admin);
        } catch (Exception e){
            if(e instanceof DuplicateKeyException){
                throw new AccountExistException(CreditConstant.CONST_MESSAGE_ACCOUNT_IN_USE);
            }
        }
    }

    @Override
    public void saveAdminRoleRelationship(Integer adminId, List<Integer> roleIdList) {
        adminMapper.deleteRelationship(adminId);
        if (roleIdList !=null && roleIdList.size()>0){
            adminMapper.insertRelationship(adminId,roleIdList);
        }
    }

    @Override
    public Admin getAdminByAcct(String userName) {
        //根据 AdminExample 查询admin
        AdminExample adminExample=new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andLoginAccountEqualTo(userName);
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if (admins.size()>0) return admins.get(0);
        return null;
    }
}
