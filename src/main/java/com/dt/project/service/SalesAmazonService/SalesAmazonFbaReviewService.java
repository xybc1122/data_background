package com.dt.project.service.salesAmazonService;

import com.dt.project.config.ResponseBase;
import com.dt.project.dto.ReviewDto;
import com.dt.project.model.salesAmazon.SalesAmazonFbaReview;

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
