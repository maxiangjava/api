package com.example.api.service;

import com.example.api.entity.UserInfo;

import java.util.Map;

/**
 * Created by matthew on 2020/10/22.
 */
public interface UserInfoService {

    UserInfo selectByPrimaryKey(Integer id);

    void pay(Map<String,Object> map);
}
