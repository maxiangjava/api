package com.example.api.dao;

import com.example.api.entity.FoodEvaluate;

import java.util.List;

public interface FoodEvaluateDao {

    List<FoodEvaluate> findByFoodId(Integer foodId);

    int insert(FoodEvaluate pojo);

    int zan(Integer id);
}