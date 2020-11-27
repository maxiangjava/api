package com.example.api.service.impl;

import com.example.api.dao.CartInfoMapper;
import com.example.api.entity.CartInfo;
import com.example.api.service.CartInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartInfoServiceImpl implements CartInfoService {

    @Autowired
    private CartInfoMapper dao;

    @Override
    public List<CartInfo> findList(Integer id) {
        // 返回所有的区域信息
        return dao.findList(id);
    }

    @Override
    public CartInfo findByFoodIdAndUserId(CartInfo record) {
        return dao.findByFoodIdAndUserId(record);
    }

    @Override
    @Transactional
    public void deleteByPrimaryKey(Integer id) {
        dao.deleteByPrimaryKey(id);
    }

    @Override
    public void delByFoodId(String foodId) {
        dao.delByFoodId(foodId);
    }

    @Override
    public void removeAll(Integer userId) {
        dao.removeAll(userId);
    }

    @Override
    @Transactional
    public void insert(CartInfo record) {
        dao.insert(record);
    }

    @Override
    @Transactional
    public void sumAdd(CartInfo record) {
        dao.sumAdd(record);
    }

    @Override
    @Transactional
    public void updateSum(CartInfo record) {
        dao.updateSum(record);
    }
}
