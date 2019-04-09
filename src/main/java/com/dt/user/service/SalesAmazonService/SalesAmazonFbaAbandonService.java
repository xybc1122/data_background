package com.dt.user.service.SalesAmazonService;

import com.dt.user.model.SalesAmazon.SalesAmazonFbaAbandon;
import java.util.List;

/**
 * @ClassName SalesAmazonFbaAbandonService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/9 13:25
 **/
public interface SalesAmazonFbaAbandonService {




    /**
     * 查询FBA遗弃
     */
    List<SalesAmazonFbaAbandon> serviceFindByListAbandon(SalesAmazonFbaAbandon abandon);




}
