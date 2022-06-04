package com.itxiaodu.credit.service.inf;

import com.itxiaodu.credit.entity.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getAll();

    void save(Menu menu);

    void update(Menu menu);

    void remove(Integer id);
}
