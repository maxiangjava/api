package com.example.api.service.impl;

import com.example.api.dao.ImgInfoDao;
import com.example.api.entity.FoodInfo;
import com.example.api.entity.ImgInfo;
import com.example.api.service.ImgInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgInfoServiceImpl implements ImgInfoService {

    @Autowired
    private ImgInfoDao dao;

    @Override
    public List<ImgInfo> findByFoodId(Integer foodId) {
        return dao.findByFoodId(foodId);
    }
}
