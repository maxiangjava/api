package com.example.api.dao;

import com.example.api.entity.AddressInfo;

import java.util.List;

public interface AddressInfoDao {

    List<AddressInfo> findListByUserId(String userId);

    AddressInfo findDefault(String userId);

    int insertSelective(AddressInfo record);

    int deleteByPrimaryKey(Integer addressId);

    int updateByPrimaryKeySelective(AddressInfo record);

    int setDefaultFalse(String userId);

//    int deleteByPrimaryKey(Integer addressId);
//
//    int insert(AddressInfo record);
//
//    int insertSelective(AddressInfo record);
//
//    AddressInfo selectByPrimaryKey(Integer addressId);
//
//    int updateByPrimaryKey(AddressInfo record);
}