package com.itxiaodu.credit.mvc.controller;

import com.github.pagehelper.PageInfo;
import com.itxiaodu.credit.constant.CreditConstant;
import com.itxiaodu.credit.entity.Role;
import com.itxiaodu.credit.service.inf.RoleService;
import com.itxiaodu.credit.util.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Controller
public class RoleController {
    RoleController() {

    }
    @Autowired
    private RoleService roleService;
    @ResponseBody
    @RequestMapping("role/get/page/info.json")
    public ResultType<PageInfo<Role>> getPageInfo(
        @RequestParam(value = "pageNum",defaultValue = CreditConstant.CONST_DEFAULT_PAGE_NUM) Integer pageNum,
        @RequestParam(value = "pageSize",defaultValue = CreditConstant.CONST_DEFAULT_PAGE_SIZE) Integer pageSize,
        @RequestParam(value = "keyword",defaultValue = "") String keyword){
        try {
            PageInfo<Role> pageInfo=roleService.getPageInfo(pageNum,pageSize,keyword);
            return ResultType.successWithData(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultType.fail(e.getMessage());
        }
    }
    @ResponseBody
    @RequestMapping("role/save.json")
    public ResultType<String> saveRole(Role role){
        roleService.save(role);
        return ResultType.successWithoutData();
    }

    @ResponseBody
    @RequestMapping("role/update.json")
    public ResultType<String> updateRole(Role role){
        roleService.update(role);
        return ResultType.successWithoutData();
    }

    @ResponseBody
    @RequestMapping("role/remove/by/roleId/array.json")
    public ResultType<String> removeByIdArray(@RequestBody List<Integer> roleIdList){
        roleService.removeRole(roleIdList);
        return ResultType.successWithoutData();
    }

}
