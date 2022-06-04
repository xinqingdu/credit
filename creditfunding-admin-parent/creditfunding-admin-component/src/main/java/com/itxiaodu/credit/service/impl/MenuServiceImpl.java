package com.itxiaodu.credit.service.impl;

import com.itxiaodu.credit.entity.Menu;
import com.itxiaodu.credit.entity.MenuExample;
import com.itxiaodu.credit.mapper.MenuMapper;
import com.itxiaodu.credit.service.inf.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    MenuServiceImpl() {

    }

    @Override
    public List<Menu> getAll() {
//        System.out.println("错了");
        return menuMapper.selectByExample(new MenuExample());
    }

    @Override
    public void save(Menu menu) {
        menuMapper.insert(menu);
    }

    @Override
    public void update(Menu menu) {
        menuMapper.updateByPrimaryKey(menu);
    }

    @Override
    public void remove(Integer id) {
        menuMapper.deleteByPrimaryKey(id);
    }
}
