package com.example.api.service.impl;

import com.example.api.dao.FoodFavoriteDao;
import com.example.api.entity.FoodFavorite;
import com.example.api.service.FoodFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodFavoriteServiceImpl implements FoodFavoriteService {

    @Autowired
    private FoodFavoriteDao dao;

    @Override
    public List<FoodFavorite> findList(String userId) {
        return dao.findList(userId);
    }

    @Override
    public int insert(FoodFavorite pojo) {
        return dao.insert(pojo);
    }
}
