package com.example.api.service;

import com.example.api.entity.AddressInfo;

import java.util.List;

/**
 * Created by matthew on 2020/10/23.
 */
public interface AddressInfoService {

    List<AddressInfo> findListByUserId(String userId);

    AddressInfo findDefault(String userId);

    int insertSelective(AddressInfo record);

    int deleteByPrimaryKey(Integer addressId);

    int updateByPrimaryKeySelective(AddressInfo record);

    int setDefaultFalse(String userId);
//
//    int insert(AddressInfo record);
//
//    int insertSelective(AddressInfo record);
//
//    AddressInfo selectByPrimaryKey(Integer addressId);
//
//    int updateByPrimaryKey(AddressInfo record);
}
