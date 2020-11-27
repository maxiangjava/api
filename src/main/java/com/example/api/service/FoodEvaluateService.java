package com.example.api.service;

import com.example.api.entity.FoodEvaluate;

import java.util.List;

/**
 * Created by matthew on 2020/10/22.
 */
public interface FoodEvaluateService {

    List<FoodEvaluate> findByFoodId(Integer foodId);

    int insert(FoodEvaluate pojo);

    int zan(Integer id);

}
