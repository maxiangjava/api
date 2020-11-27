package com.example.api.dao;

import com.example.api.entity.OrderInfo;

import java.util.List;
import java.util.Map;

public interface OrderInfoMapper {

    int insert(OrderInfo record);

    OrderInfo findByOrderId(String orderId);

    int cancelOrder(String orderId);

    int updateState(Map<String,Object> map);

    List<OrderInfo> findByStatus(OrderInfo record);

    List<OrderInfo> findByStatusAll(String userId);

}