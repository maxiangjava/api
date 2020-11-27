package com.example.api.service.impl;

import com.example.api.dao.OrderInfoMapper;
import com.example.api.entity.OrderInfo;
import com.example.api.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderInfoMapper dao;

    @Override
    @Transactional
    public void insert(OrderInfo record) {
        dao.insert(record);
    }

    @Override
    public OrderInfo findByOrderId(String orderId) {
        return dao.findByOrderId(orderId);
    }

    @Override
    public List<OrderInfo> findByStatus(OrderInfo record) {
        return dao.findByStatus(record);
    }

    @Override
    public List<OrderInfo> findByStatusAll(String userId) {
        return dao.findByStatusAll(userId);
    }

    @Override
    @Transactional
    public int updateState(Map<String, Object> map) {
        return dao.updateState(map);
    }

    @Override
    @Transactional
    public int cancelOrder(String orderId) {
        return dao.cancelOrder(orderId);
    }
}
