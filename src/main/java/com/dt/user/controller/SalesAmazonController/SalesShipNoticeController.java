package com.dt.user.controller.SalesAmazonController;

import com.dt.user.config.ResponseBase;
import com.dt.user.model.SalesAmazon.SalesShipNotice;
import com.dt.user.service.JavaSqlNameService;
import com.dt.user.service.SalesAmazonService.SalesShipNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SalesShipNoticeController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/10 17:23
 **/
@RestController
@RequestMapping("/api/v1/no")
public class SalesShipNoticeController {
    @Autowired
    private SalesShipNoticeService noticeService;
    @Autowired
    private JavaSqlNameService nameService;

    /**
     * 查询发货通知单信息
     *
     * @return
     */
    @PostMapping("/getNotice")
    public ResponseBase getBusInfo(@RequestBody SalesShipNotice notice) {
        //这里放入缓存
        notice.setNameList(nameService.get("shipNotice"));
        return noticeService.selectSelectByNotice(notice);
    }


}
