package com.example.api.dao;

import com.example.api.entity.CartInfo;

import java.util.List;

public interface CartInfoMapper {
    List<CartInfo> findList(Integer userId);

    int deleteByPrimaryKey(Integer id);

    int removeAll(Integer userId);

    int delByFoodId(String foodId);

    CartInfo findByFoodIdAndUserId(CartInfo record);

    int insert(CartInfo record);

    int sumAdd(CartInfo record);

    int updateSum(CartInfo record);

    CartInfo selectByPrimaryKey(Integer id);

}