package com.example.api.service;

import com.example.api.entity.FoodInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by matthew on 2020/10/22.
 */
public interface FoodInfoService {

    List<FoodInfo> findList(Integer menuId);

    List<FoodInfo> findLike();

    FoodInfo findFoodByKey(Integer foodId);

    /**
     * 销售成功改变销量和库存
     */
    int sell(Map<String,Object> sell);

    /**
     * 浏览量加一
     */
    int browse(String foodId);
}
