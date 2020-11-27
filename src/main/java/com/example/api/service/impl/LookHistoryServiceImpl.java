package com.example.api.service.impl;

import com.example.api.dao.LookHistoryMapper;
import com.example.api.entity.LookHistory;
import com.example.api.service.LookHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by matthew on 2020/11/20.
 */
@Service
public class LookHistoryServiceImpl implements LookHistoryService{

    @Autowired
    private LookHistoryMapper dao;

    @Override
    public int insert(LookHistory pojo) {
        return dao.insert(pojo);
    }

    @Override
    public List<LookHistory> findByUserId(String userId) {
        return dao.findByUserId(userId);
    }
}
