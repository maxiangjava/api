package com.example.api.dao;

import com.example.api.entity.OrderDetail;

import java.util.List;

public interface OrderDetailMapper {

    int insert(OrderDetail record);

    int cancelOrder(String orderId);

    List<OrderDetail> findByOrderId(String orderId);

}