package com.example.api.dao;

import com.example.api.entity.Favorite;
import com.example.api.entity.FoodFavorite;
import com.example.api.entity.FoodInfo;

import java.util.List;

/**
 * Created by matthew on 2020/10/22.
 */


public interface FoodFavoriteDao {

    List<Favorite> findList(String userId);

    FoodFavorite findByUserIdFoodId(FoodFavorite pojo);

    int insert(FoodFavorite pojo);

    int delByKey(String favoriteId);

    int remove(String userId);

}
