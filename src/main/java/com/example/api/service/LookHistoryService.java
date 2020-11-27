package com.example.api.service;

import com.example.api.entity.LookHistory;

import java.util.List;

/**
 * Created by matthew on 2020/10/22.
 */
public interface LookHistoryService {

    int insert(LookHistory pojo);

    List<LookHistory> findByUserId(String userId);
}
