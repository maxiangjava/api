package com.example.api.service;

import com.example.api.entity.OrderDetail;

import java.util.List;

/**
 * Created by matthew on 2020/10/22.
 */
public interface OrderDetailService {

    void insert(OrderDetail record);

    int cancelOrder(String orderId);

    List<OrderDetail> findByOrderId(String orderId);
}
