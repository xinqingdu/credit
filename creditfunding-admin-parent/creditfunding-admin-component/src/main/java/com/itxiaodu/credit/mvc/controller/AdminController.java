package com.itxiaodu.credit.mvc.controller;

import com.github.pagehelper.PageInfo;
import com.itxiaodu.credit.constant.CreditConstant;
import com.itxiaodu.credit.entity.Admin;
import com.itxiaodu.credit.exception.DeleteException;
import com.itxiaodu.credit.service.inf.AdminService;
import com.itxiaodu.credit.util.JudgeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.request.SessionScope;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class AdminController {
    private static final String getPageInfo="admin/get/page.html";
    AdminController() {

    }

    @Autowired
    private AdminService adminService;

    @RequestMapping(getPageInfo)
    public String getPageInfo(@RequestParam(value = "keyword", defaultValue = "") String keyword,
                              @RequestParam(value = "pageNum", defaultValue = CreditConstant.CONST_DEFAULT_PAGE_NUM) Integer pageNum,
                              @RequestParam(value = "pageSize", defaultValue = CreditConstant.CONST_DEFAULT_PAGE_SIZE) Integer pageSize,
                              ModelMap modelMap) {
        PageInfo<Admin> pageInfo = adminService.getPageInfo(keyword, pageNum, pageSize);
//        if(!pageInfo.getList().isEmpty()){
//            System.out.println(pageInfo.getList().get(0).toString());
//        }
        modelMap.addAttribute(CreditConstant.CONST_NAME_PAGE_INFO, pageInfo);
        return "admin-page";
    }

    //    退出系统注销session
    @RequestMapping("security/do/logout.html")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/security/to/login/page.html";
    }

    @RequestMapping(value = "security/do/login.html")
    public String login(@RequestParam("loginAcct") String loginAccount, @RequestParam("userPswd") String password, HttpSession session) {
        //登录检查
        Admin admin = adminService.getLoginAcctAdmin(loginAccount, password);
        //将登录成功admin对象存入session
        session.setAttribute(CreditConstant.CONST_ADMIN_LOGIN, admin);
//        return "admin-main";
        return "redirect:/security/to/main/page.html";
    }
    @RequestMapping("admin/remove/{id}/{pageNum}/{keyword}.html")
    public String remove(@PathVariable("id") Integer id,
                         @PathVariable("pageNum") Integer pageNum,
                         @PathVariable("keyword") String keyword,
                         HttpSession session) {
        //检查部分已经在前端做好，此处无用
        Admin admin = (Admin) session.getAttribute(CreditConstant.CONST_ADMIN_LOGIN);
        if (!admin.getId().equals(id)) {
            adminService.remove(id);
        }else {
            throw new DeleteException(CreditConstant.CONST_DELETE_EXCEPTION);
        }
        return "redirect:/admin/get/page.html?pageNum=" + pageNum + " &keyword=" + keyword;
    }
    @PreAuthorize("hasAuthority('user:save')")
    @RequestMapping("admin/save.html")
    public String save(Admin admin){
        adminService.save(admin);
        return "redirect:/admin/get/page.html?pageNum"+Integer.MIN_VALUE;
    }

    @RequestMapping("admin/to/edit/page.html")
    public String toEditPage(@RequestParam("adminId") Integer adminId,
                             @RequestParam("pageNum") Integer pageNum,
                             @RequestParam("keyword") String keyword,
                             ModelMap modelMap){
        Admin admin = adminService.getAdminById(adminId);
        modelMap.addAttribute("admin",admin);
        return "admin-edit";
    }
    @RequestMapping("admin/update.html")
    public String update(Admin admin,
                         @RequestParam("pageNum") Integer pageNum,
                         @RequestParam("keyword") String keyword){
        adminService.update(admin);
        return "redirect:/admin/get/page.html?pageNum=" + pageNum + " &keyword=" + keyword;
    }
}
