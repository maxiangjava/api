package com.example.api.service.impl;

import com.example.api.dao.FoodEvaluateDao;
import com.example.api.entity.FoodEvaluate;
import com.example.api.service.FoodEvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FoodEvaluateServiceImpl implements FoodEvaluateService {

    @Autowired
    private FoodEvaluateDao dao;

    @Override
    public List<FoodEvaluate> findByFoodId(Integer foodId) {
        // 返回所有的区域信息
        return dao.findByFoodId(foodId);
    }

    @Override
    @Transactional
    public int insert(FoodEvaluate pojo) {
        return dao.insert(pojo);
    }

    @Override
    public int zan(Integer id) {
        return dao.zan(id);
    }
}
