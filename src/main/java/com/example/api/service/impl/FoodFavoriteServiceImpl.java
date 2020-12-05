package com.example.api.service.impl;

import com.example.api.dao.FoodFavoriteDao;
import com.example.api.entity.Favorite;
import com.example.api.entity.FoodFavorite;
import com.example.api.entity.FoodInfo;
import com.example.api.service.FoodFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodFavoriteServiceImpl implements FoodFavoriteService {

    @Autowired
    private FoodFavoriteDao dao;

    @Override
    public List<Favorite> findList(String userId) {
        return dao.findList(userId);
    }

    @Override
    public FoodFavorite findByUserIdFoodId(FoodFavorite pojo) {
        return dao.findByUserIdFoodId(pojo);
    }

    @Override
    public int insert(FoodFavorite pojo) {
        return dao.insert(pojo);
    }

    @Override
    public int delByKey(String favoriteId) {
        return dao.delByKey(favoriteId);
    }

    @Override
    public int remove(String userId) {
        return dao.remove(userId);
    }
}
