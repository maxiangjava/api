package com.example.api.service.impl;

import com.example.api.dao.OrderDetailMapper;
import com.example.api.entity.OrderDetail;
import com.example.api.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailMapper dao;

    @Override
    @Transactional
    public void insert(OrderDetail record) {
        dao.insert(record);
    }

    @Override
    public List<OrderDetail> findByOrderId(String orderId) {
        return dao.findByOrderId(orderId);
    }

    @Override
    public int cancelOrder(String orderId) {
        return dao.cancelOrder(orderId);
    }
}
