package com.dt.project.controller.salesAmazonController;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.salesAmazon.SalesShipNotice;
import com.dt.project.service.JavaSqlNameService;
import com.dt.project.service.salesAmazonService.SalesShipNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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
    public ResponseBase getNotice(@RequestBody SalesShipNotice notice) {
        //这里放入缓存
        notice.setNameList(nameService.get("shipNotice"));
        return noticeService.selectSelectByNotice(notice);
    }

    /**
     * 新增发货通知单
     *
     * @return
     */
    @PostMapping("/saveNotice")
    public ResponseBase saveNotice(@RequestBody Map<String, Object> noMap) {
        return noticeService.saveNotice(noMap);
    }

}
