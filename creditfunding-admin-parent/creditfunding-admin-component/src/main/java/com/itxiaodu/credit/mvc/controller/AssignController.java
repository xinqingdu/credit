package com.itxiaodu.credit.mvc.controller;

import com.itxiaodu.credit.entity.Auth;
import com.itxiaodu.credit.entity.Role;
import com.itxiaodu.credit.service.inf.AdminService;
import com.itxiaodu.credit.service.inf.AuthService;
import com.itxiaodu.credit.service.inf.RoleService;
import com.itxiaodu.credit.util.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class AssignController {
    private static final String toAssignRolePage="assign/to/assign/role/page.html";
    private static final String saveAdminRoleRelationship="assign/do/role/assign.html";
    private static final String getAllAuth="assign/get/all/auth.json";
    private static final String getAssignedRoleAuth="assign/get/assigned/roleAuth.json";
    private static final String saveAssignedRoleAuth="assign/do/assigned/roleAuth.json";
    AssignController() {

    }

    @Autowired
    private AdminService adminService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private AuthService authService;

    @RequestMapping(toAssignRolePage)
    public String toAssignRolePage(@RequestParam("adminId") Integer adminId,
                                   ModelMap modelMap) {
        System.out.println(adminId);
        List<Role> assignedRoleList = roleService.getAssignedRole(adminId);
        List<Role> unassignedRoleList = roleService.getUnassignedRole(adminId);
//        System.out.println(assignedRoleList.size());
//        System.out.println(unassignedRoleList.size());
        //存为modelMap模型
        modelMap.addAttribute("assignedRoleList", assignedRoleList);
        modelMap.addAttribute("unassignedRoleList", unassignedRoleList);
        return "assign-role";
    }

    @RequestMapping(saveAdminRoleRelationship)
    public String saveAdminRoleRelationship(@RequestParam("adminId") Integer adminId,
                                            @RequestParam("pageNum") Integer pageNum,
                                            @RequestParam("keyword") String keyword,
                                            @RequestParam(value = "roleIdList",required = false) List<Integer> roleIdList) {
        adminService.saveAdminRoleRelationship(adminId,roleIdList);
        return "redirect:/admin/get/page.html?pageNum=" + pageNum + " &keyword=" + keyword;
    }
    @ResponseBody
    @RequestMapping(getAllAuth)
    public ResultType<List<Auth>> getAllAuth(){
        List<Auth> authList=authService.getAll();
//        for(Auth auth:authList){
//            System.out.println(auth.toString());
//        }
        return ResultType.successWithData(authList);
    }
    @ResponseBody
    @RequestMapping(getAssignedRoleAuth)
    public ResultType<List<Integer>> getAssignedRoleAuth(
        @RequestParam("roleId") Integer roleId){
        List<Integer> authIdList= authService.getAssignedRoleAuth(roleId);
//        for (Integer integer:authIdList){
//            System.out.println(integer);
//        }
        return ResultType.successWithData(authIdList);
    }
    @ResponseBody
    @RequestMapping(saveAssignedRoleAuth)
    public ResultType<String> saveAssignedRoleAuth(@RequestBody Map<String,List<Integer>> map){
        authService.saveAssignedRoleAuth(map);
        return ResultType.successWithoutData();
    }
}
