package com.example.api.dao;

import com.example.api.entity.PayHistory;

import java.util.List;

public interface PayHistoryMapper {

    List<PayHistory> findList(String userId);

    int insert(PayHistory record);

}