package com.example.api.entity;

import java.io.Serializable;
import java.util.Date;

public class FoodEvaluate implements Serializable {
    private Integer id;

    private String foodId;

    private Integer star;

    private Integer zan;

    private String content;

    private String userId;

    private String evaluateUserName;

    private String evaluateUserImg;

    private Date evaluateTime;

    private String evaluateImgOne;

    private String evaluateImgTwo;

    private String evaluateImgThree;

    private String evaluateImgFour;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId == null ? null : foodId.trim();
    }

    public Integer getZan() {
        return zan;
    }

    public void setZan(Integer zan) {
        this.zan = zan;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEvaluateUserName() {
        return evaluateUserName;
    }

    public void setEvaluateUserName(String evaluateUserName) {
        this.evaluateUserName = evaluateUserName == null ? null : evaluateUserName.trim();
    }

    public String getEvaluateUserImg() {
        return evaluateUserImg;
    }

    public void setEvaluateUserImg(String evaluateUserImg) {
        this.evaluateUserImg = evaluateUserImg == null ? null : evaluateUserImg.trim();
    }

    public Date getEvaluateTime() {
        return evaluateTime;
    }

    public void setEvaluateTime(Date evaluateTime) {
        this.evaluateTime = evaluateTime;
    }

    public String getEvaluateImgOne() {
        return evaluateImgOne;
    }

    public void setEvaluateImgOne(String evaluateImgOne) {
        this.evaluateImgOne = evaluateImgOne == null ? null : evaluateImgOne.trim();
    }

    public String getEvaluateImgTwo() {
        return evaluateImgTwo;
    }

    public void setEvaluateImgTwo(String evaluateImgTwo) {
        this.evaluateImgTwo = evaluateImgTwo == null ? null : evaluateImgTwo.trim();
    }

    public String getEvaluateImgThree() {
        return evaluateImgThree;
    }

    public void setEvaluateImgThree(String evaluateImgThree) {
        this.evaluateImgThree = evaluateImgThree == null ? null : evaluateImgThree.trim();
    }

    public String getEvaluateImgFour() {
        return evaluateImgFour;
    }

    public void setEvaluateImgFour(String evaluateImgFour) {
        this.evaluateImgFour = evaluateImgFour == null ? null : evaluateImgFour.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        FoodEvaluate other = (FoodEvaluate) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFoodId() == null ? other.getFoodId() == null : this.getFoodId().equals(other.getFoodId()))
            && (this.getStar() == null ? other.getStar() == null : this.getStar().equals(other.getStar()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getEvaluateUserName() == null ? other.getEvaluateUserName() == null : this.getEvaluateUserName().equals(other.getEvaluateUserName()))
            && (this.getEvaluateUserImg() == null ? other.getEvaluateUserImg() == null : this.getEvaluateUserImg().equals(other.getEvaluateUserImg()))
            && (this.getEvaluateTime() == null ? other.getEvaluateTime() == null : this.getEvaluateTime().equals(other.getEvaluateTime()))
            && (this.getEvaluateImgOne() == null ? other.getEvaluateImgOne() == null : this.getEvaluateImgOne().equals(other.getEvaluateImgOne()))
            && (this.getEvaluateImgTwo() == null ? other.getEvaluateImgTwo() == null : this.getEvaluateImgTwo().equals(other.getEvaluateImgTwo()))
            && (this.getEvaluateImgThree() == null ? other.getEvaluateImgThree() == null : this.getEvaluateImgThree().equals(other.getEvaluateImgThree()))
            && (this.getEvaluateImgFour() == null ? other.getEvaluateImgFour() == null : this.getEvaluateImgFour().equals(other.getEvaluateImgFour()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFoodId() == null) ? 0 : getFoodId().hashCode());
        result = prime * result + ((getStar() == null) ? 0 : getStar().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getEvaluateUserName() == null) ? 0 : getEvaluateUserName().hashCode());
        result = prime * result + ((getEvaluateUserImg() == null) ? 0 : getEvaluateUserImg().hashCode());
        result = prime * result + ((getEvaluateTime() == null) ? 0 : getEvaluateTime().hashCode());
        result = prime * result + ((getEvaluateImgOne() == null) ? 0 : getEvaluateImgOne().hashCode());
        result = prime * result + ((getEvaluateImgTwo() == null) ? 0 : getEvaluateImgTwo().hashCode());
        result = prime * result + ((getEvaluateImgThree() == null) ? 0 : getEvaluateImgThree().hashCode());
        result = prime * result + ((getEvaluateImgFour() == null) ? 0 : getEvaluateImgFour().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", foodId=").append(foodId);
        sb.append(", star=").append(star);
        sb.append(", content=").append(content);
        sb.append(", evaluateUserName=").append(evaluateUserName);
        sb.append(", evaluateUserImg=").append(evaluateUserImg);
        sb.append(", evaluateTime=").append(evaluateTime);
        sb.append(", evaluateImgOne=").append(evaluateImgOne);
        sb.append(", evaluateImgTwo=").append(evaluateImgTwo);
        sb.append(", evaluateImgThree=").append(evaluateImgThree);
        sb.append(", evaluateImgFour=").append(evaluateImgFour);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}