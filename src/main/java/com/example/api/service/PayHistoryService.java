package com.example.api.service;

import com.example.api.entity.PayHistory;

import java.util.List;

/**
 * Created by matthew on 2020/10/22.
 */
public interface PayHistoryService {

    List<PayHistory> findList(String userId);

    int insert(PayHistory pojo);

}
