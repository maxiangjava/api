package com.example.api.entity;

import java.util.List;

/**
 * Created by matthew on 2020/11/19.
 */
public class Food {
    private FoodInfo foodInfo;

    private List<FoodEvaluate> foodEvaluateList;

    private List<ImgInfo> imgInfoList;

    public FoodInfo getFoodInfo() {
        return foodInfo;
    }

    public void setFoodInfo(FoodInfo foodInfo) {
        this.foodInfo = foodInfo;
    }

    public List<FoodEvaluate> getFoodEvaluateList() {
        return foodEvaluateList;
    }

    public void setFoodEvaluateList(List<FoodEvaluate> foodEvaluateList) {
        this.foodEvaluateList = foodEvaluateList;
    }

    public List<ImgInfo> getImgInfoList() {
        return imgInfoList;
    }

    public void setImgInfoList(List<ImgInfo> imgInfoList) {
        this.imgInfoList = imgInfoList;
    }
}
