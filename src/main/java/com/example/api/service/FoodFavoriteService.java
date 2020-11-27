package com.example.api.service;

import com.example.api.entity.FoodFavorite;

import java.util.List;

/**
 * Created by matthew on 2020/10/22.
 */
public interface FoodFavoriteService {

    List<FoodFavorite> findList(String userId);

    int insert(FoodFavorite pojo);
}
