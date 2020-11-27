package com.example.api.dao;

import com.example.api.entity.LookHistory;

import java.util.List;

public interface LookHistoryMapper {

    int insert(LookHistory record);

    List<LookHistory> findByUserId(String userId);

}