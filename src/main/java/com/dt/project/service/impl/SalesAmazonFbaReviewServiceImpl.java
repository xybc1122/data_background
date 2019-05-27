package com.dt.project.service.impl;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.dto.ReviewDto;
import com.dt.project.exception.LsException;
import com.dt.project.mapper.salesAmazonMapper.SalesAmazonFbaReviewMapper;
import com.dt.project.model.salesAmazon.SalesAmazonFbaReview;
import com.dt.project.service.salesAmazonService.SalesAmazonFbaReviewService;
import com.dt.project.toos.Constants;
import com.dt.project.utils.JsonUtils;
import com.dt.project.utils.ReqUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

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
    private ReentrantLock lock = new ReentrantLock();


    @Override
    public List<SalesAmazonFbaReview> serviceSelectByReview(ReviewDto reviewDto) {
        return reviewMapper.selectByReview(reviewDto);
    }

    @Override
    public ResponseBase serviceInsertReview(SalesAmazonFbaReview review) {
        try {
            lock.lock();
            check(review, "数据已存在不能存入", Constants.SAVE);
            int result = reviewMapper.insertReview(review);
            return JsonUtils.saveMsg(result);
        } finally {
            lock.unlock();
        }
    }

    @Override
    @Transactional
    public ResponseBase serviceDelReview(String thisIds, String versions) {
        if (thisIds.contains(",")) {
            String[] strReIds = thisIds.split(",");
            String[] strVersion = versions.split(",");
            for (int i = 0; i < strReIds.length; i++) {
                Long reId = Long.parseLong(strReIds[i]);
                Integer version = Integer.parseInt(strVersion[i]);
                int result = reviewMapper.delByReview(reId, version);
                if (result == 0) {
                    throw new LsException("删除失败");
                }
            }
            return JsonData.setResultSuccess("success");
        } else {
            int result = reviewMapper.delByReview(Long.parseLong(thisIds), Integer.parseInt(versions));
            return JsonUtils.saveMsg(result);
        }
    }

    @Override
    public ResponseBase serviceUpdateByReview(SalesAmazonFbaReview review) {
        check(review, "数据已存在不能修改", Constants.UP);
        int result = reviewMapper.updateByReview(review);
        return JsonUtils.saveMsg(result);
    }


    private void check(SalesAmazonFbaReview review, String msg, String type) {
        Long reId = reviewMapper.selectIsReview(review);
        switch (type) {
            case "save":
                if (reId != null) {
                    throw new LsException(msg);
                }
                break;
            case "up":
                if (reId != null && !reId.equals(review.getReId())) {
                    throw new LsException(msg);
                }
                break;
        }
        review.setCreateDate(new Date().getTime());
        review.setCreateUser(ReqUtils.getUserName());
    }

}
