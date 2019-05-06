package com.dt.user.service.impl;

import com.dt.user.config.ResponseBase;
import com.dt.user.dto.ReviewDto;
import com.dt.user.mapper.SalesAmazonMapper.SalesAmazonFbaReviewMapper;
import com.dt.user.model.SalesAmazon.SalesAmazonFbaReview;
import com.dt.user.service.SalesAmazonService.SalesAmazonFbaReviewService;
import com.dt.user.utils.JsonUtils;
import com.dt.user.utils.ReqUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName SalesAmazonFbaReviewServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/23 10:46
 **/
@Service
public class SalesAmazonFbaReviewServiceImpl implements SalesAmazonFbaReviewService {
    @Autowired
    private SalesAmazonFbaReviewMapper reviewMapper;

    @Override
    public List<SalesAmazonFbaReview> serviceSelectByReview(ReviewDto reviewDto) {
        return reviewMapper.selectByReview(reviewDto);
    }

    @Override
    public ResponseBase serviceInsertReview(SalesAmazonFbaReview review) {
        review.setCreateDate(new Date().getTime());
        review.setCreateUser(ReqUtils.getUserName());
        int result = reviewMapper.insertReview(review);
        return JsonUtils.saveMsg(result);
    }
}
