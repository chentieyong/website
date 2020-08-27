package com.shenzhou.entity.focus;

/**
 * Created by cty on 2016/11/17.
 */
public class FocusInfo {
    private String picturePath;//图片路径
    private Integer orderSeq;

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public Integer getOrderSeq() {
        return orderSeq;
    }

    public void setOrderSeq(Integer orderSeq) {
        this.orderSeq = orderSeq;
    }
}
