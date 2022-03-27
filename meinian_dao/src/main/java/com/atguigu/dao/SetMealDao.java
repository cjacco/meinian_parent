package com.atguigu.dao;

import com.atguigu.pojo.Setmeal;
import com.atguigu.pojo.TravelGroup;
import com.atguigu.pojo.TravelItem;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

public interface SetMealDao {
    void add(Setmeal setMeal);

    void setSetmealAndTravelGroup(Map<String, Integer> map);

    Page<Setmeal> findPage(String queryString);

    List<Setmeal> findAll();

    Setmeal findById(Integer id);

    TravelGroup findTravelGroupListById(Integer id);

    TravelItem findTravelItemListById(Integer id);

    List<Map<String, Object>> findSetmealCount();
}
