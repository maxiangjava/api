package com.example.api.entity;

import java.util.List;

/**
 * Created by matthew on 2020/11/18.
 */
public class Order {

    private OrderInfo orderInfo;

    private List<OrderDetail> orderDetailList;

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}
