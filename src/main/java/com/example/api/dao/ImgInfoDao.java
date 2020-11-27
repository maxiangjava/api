package com.example.api.dao;

import com.example.api.entity.ImgInfo;

import java.util.List;

public interface ImgInfoDao {

    List<ImgInfo> findByFoodId(Integer foodId);

}