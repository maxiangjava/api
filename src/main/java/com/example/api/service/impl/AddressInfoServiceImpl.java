package com.example.api.service.impl;

import com.example.api.dao.AddressInfoDao;
import com.example.api.entity.AddressInfo;
import com.example.api.service.AddressInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by matthew on 2020/10/23.
 */
@Service
public class AddressInfoServiceImpl implements AddressInfoService{

    @Autowired
    private AddressInfoDao addressInfoDao;

    @Override
    public List<AddressInfo> findListByUserId(String userId) {
        return addressInfoDao.findListByUserId(userId);
    }

    @Override
    public AddressInfo findDefault(String userId) {
        return addressInfoDao.findDefault(userId);
    }

    @Override
    @Transactional
    public int insertSelective(AddressInfo record) {
        return addressInfoDao.insertSelective(record);
    }

    @Override
    @Transactional
    public int updateByPrimaryKeySelective(AddressInfo record) {
        return addressInfoDao.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional
    public int setDefaultFalse(String userId) {
        return addressInfoDao.setDefaultFalse(userId);
    }

    @Override
    public int deleteByPrimaryKey(Integer addressId) {
        return addressInfoDao.deleteByPrimaryKey(addressId);
    }
}
