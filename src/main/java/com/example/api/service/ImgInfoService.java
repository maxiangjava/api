package com.example.api.service;

import com.example.api.entity.ImgInfo;

import java.util.List;

/**
 * Created by matthew on 2020/10/22.
 */
public interface ImgInfoService {

    List<ImgInfo> findByFoodId(Integer foodId);

}
