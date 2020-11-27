package com.example.api.service;

import com.example.api.entity.CartInfo;

import java.util.List;

/**
 * Created by matthew on 2020/10/22.
 */
public interface CartInfoService {

    List<CartInfo> findList(Integer userId);

    CartInfo findByFoodIdAndUserId(CartInfo record);

    void deleteByPrimaryKey(Integer id);

    void removeAll(Integer userId);

    void delByFoodId(String foodId);

    void insert(CartInfo record);

    void sumAdd(CartInfo record);

    void updateSum(CartInfo record);

}
