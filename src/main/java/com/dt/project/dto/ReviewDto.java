package com.dt.project.dto;

import com.dt.project.model.salesAmazon.SalesAmazonFbaReview;

/**
 * @ClassName ReviewDto
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/23 10:35
 **/
public class ReviewDto extends SalesAmazonFbaReview {


    /**
     * 星级
     */
    private String starLevelName;

    public String getStarLevelName() {
        return starLevelName;
    }

    public void setStarLevelName(String starLevelName) {
        this.starLevelName = starLevelName;
    }
}
