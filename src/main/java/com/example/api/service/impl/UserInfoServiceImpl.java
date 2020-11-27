package com.example.api.service.impl;

import com.example.api.dao.UserInfoDao;
import com.example.api.entity.UserInfo;
import com.example.api.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao dao;

    @Override
    public UserInfo selectByPrimaryKey(Integer id) {
        // 返回所有的区域信息
        return dao.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public void pay(Map<String,Object> map) {
        dao.pay(map);
    }
}
