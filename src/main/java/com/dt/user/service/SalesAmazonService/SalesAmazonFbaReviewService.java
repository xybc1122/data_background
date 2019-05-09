package com.dt.user.service.SalesAmazonService;

import com.dt.user.config.ResponseBase;
import com.dt.user.dto.ReviewDto;
import com.dt.user.model.SalesAmazon.SalesAmazonFbaReview;

import java.util.List;

/**
 * @ClassName SalesAmazonFbaReviewService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/23 10:45
 **/

public interface SalesAmazonFbaReviewService {


    /**
     * 查询 review
     *
     * @return
     */
    List<SalesAmazonFbaReview> serviceSelectByReview(ReviewDto reviewDto);

    ResponseBase serviceInsertReview(SalesAmazonFbaReview review);


    /**
     * 物理删除 更新数据
     *
     * @return
     */
    ResponseBase serviceDelReview(String thisIds, String versions);


    /**
     * 更新数据
     *
     * @return
     */
    ResponseBase serviceUpdateByReview(SalesAmazonFbaReview review);


}
