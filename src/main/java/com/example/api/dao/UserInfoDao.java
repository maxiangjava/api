package com.example.api.dao;


import com.example.api.entity.UserInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface UserInfoDao {

    UserInfo selectByPrimaryKey(Integer id);

    int pay(Map<String,Object> map);
}