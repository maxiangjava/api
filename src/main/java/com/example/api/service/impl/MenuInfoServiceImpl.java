package com.example.api.service.impl;

import com.example.api.dao.MenuInfoDao;
import com.example.api.entity.MenuInfo;
import com.example.api.service.MenuInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuInfoServiceImpl implements MenuInfoService {

    @Autowired
    private MenuInfoDao menuInfoDao;

    @Override
    public List<MenuInfo> queryMenuInfo() {
        // 返回所有的区域信息
        return menuInfoDao.queryMenuInfo();
    }
}
