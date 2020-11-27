package com.example.api.service;

import com.example.api.entity.MenuInfo;
import com.example.api.entity.UserInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by matthew on 2020/10/22.
 */
public interface UserInfoService {

    UserInfo selectByPrimaryKey(Integer id);

    int pay(Map<String,Object> map);
}
