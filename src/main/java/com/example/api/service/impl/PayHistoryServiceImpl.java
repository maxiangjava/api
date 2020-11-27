package com.example.api.service.impl;

import com.example.api.dao.PayHistoryMapper;
import com.example.api.entity.PayHistory;
import com.example.api.service.PayHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by matthew on 2020/11/20.
 */
@Service
public class PayHistoryServiceImpl implements PayHistoryService{

    @Autowired
    private PayHistoryMapper dao;

    @Override
    @Transactional
    public int insert(PayHistory pojo) {
        return dao.insert(pojo);
    }

    @Override
    public List<PayHistory> findList(String userId) {
        return dao.findList(userId);
    }
}
