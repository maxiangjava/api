package com.example.api.service.impl;

import com.example.api.dao.FoodInfoDao;
import com.example.api.entity.FoodInfo;
import com.example.api.service.FoodInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FoodInfoServiceImpl implements FoodInfoService {

    @Autowired
    private FoodInfoDao dao;

    @Override
    public List<FoodInfo> findList(Integer menuId) {
        // 返回所有的区域信息
        return dao.findList(menuId);
    }

    @Override
    public List<FoodInfo> findLike() {
        return dao.findLike();
    }

    @Override
    public FoodInfo findFoodByKey(Integer foodId) {
        return dao.findFoodByKey(foodId);
    }

    @Override
    public int sell(Map<String, Object> sell) {
        return dao.sell(sell);
    }


    @Override
    public int browse(String foodId) {
        return dao.browse(foodId);
    }
}
