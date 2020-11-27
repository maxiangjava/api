package com.example.api.service;

import com.example.api.entity.OrderInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by matthew on 2020/10/22.
 */
public interface OrderInfoService {

    void insert(OrderInfo record);

    int updateState(Map<String,Object> map);

    OrderInfo findByOrderId(String orderId);

    int cancelOrder(String orderId);

    List<OrderInfo> findByStatus(OrderInfo record);

    List<OrderInfo> findByStatusAll(String userId);
}
