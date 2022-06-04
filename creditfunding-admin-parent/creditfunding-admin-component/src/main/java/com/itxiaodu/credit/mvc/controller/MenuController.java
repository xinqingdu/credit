package com.itxiaodu.credit.mvc.controller;

import com.itxiaodu.credit.entity.Menu;
import com.itxiaodu.credit.service.inf.MenuService;
import com.itxiaodu.credit.util.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

//@Controller
//@ResponseBody
@RestController
//RestController=Controller+ResponseBody
public class MenuController {
    @Autowired
    private MenuService menuService;
    MenuController() {

    }

//    @ResponseBody
    @PreAuthorize("hasRole('经理')")
    @RequestMapping("menu/get/whole/tree.json")
    public ResultType<Menu> getWholeTree(){
        try {
            menuService.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Menu> menuList = menuService.getAll();
        Menu root=null;
        Map<Integer, Menu> integerMenuHashMap = new HashMap<>();
        for(Menu menu:menuList){
            Integer id = menu.getId();
            integerMenuHashMap.put(id,menu);
        }
        for (Menu menu:menuList) {
            Integer pid=menu.getPid();
            if (pid==null){
                root=menu;
                continue;
            }
            Menu father=integerMenuHashMap.get(pid);
            father.getChildren().add(menu);
        }
        return ResultType.successWithData(root);
    }

//    @ResponseBody
    @RequestMapping("menu/save.json")
    public ResultType<String> saveMenu(Menu menu){
        menuService.save(menu);
        return ResultType.successWithoutData();
    }

//    @ResponseBody
    @RequestMapping("menu/update.json")
    public ResultType<String> updateMenu(Menu menu){
        menuService.update(menu);
        return ResultType.successWithoutData();
    }

//    @ResponseBody
    @RequestMapping("menu/remove.json")
    public ResultType<String> remove(@RequestParam("id") Integer id){
        menuService.remove(id);
        return ResultType.successWithoutData();
    }
}
