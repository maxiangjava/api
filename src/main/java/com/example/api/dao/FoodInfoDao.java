package com.example.api.dao;

import com.example.api.entity.FoodInfo;

import java.util.List;
import java.util.Map;

public interface FoodInfoDao {

    List<FoodInfo> findList(Integer menuId);

    List<FoodInfo> findLike();

    FoodInfo findFoodByKey(Integer foodId);

    int sell(Map<String,Object> sell);

    int browse(String foodId);
}