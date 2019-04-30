package com.dt.user;


import com.dt.user.mapper.BasePublicMapper.BasicPublicShopMapper;
import com.dt.user.mapper.FinancialImportMapper.FinancialSalesBalanceMapper;
import com.dt.user.mapper.SystemMapper.SystemFinalProcessingMapper;
import com.dt.user.model.BasePublicModel.BasicPublicShop;
import com.dt.user.model.FinancialSalesBalance;
import com.dt.user.model.JavaSqlName;
import com.dt.user.model.SalesAmazon.SalesAmazonFbaReview;
import com.dt.user.service.FinancialImportService.FinancialSalesBalanceService;
import com.dt.user.service.JavaSqlNameService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {
    @Autowired
    private JavaSqlNameService service;
    @Autowired
    private SystemFinalProcessingMapper pMapper;
    @Autowired
    private FinancialSalesBalanceMapper fsbMapper;
    @Autowired
    private BasicPublicShopMapper shopMapper;

    @Test
    public void add() {

        SalesAmazonFbaReview f = new SalesAmazonFbaReview();
        Field[] field = f.getClass().getDeclaredFields();
        for (Field s : field) {
            s.setAccessible(true);
            JavaSqlName b = new JavaSqlName();
            b.setjName(s.getName());
            b.setModel("review");
            service.serviceSet(b);
        }
    }

//  查询站点权限的
//  SELECT site_id,site_name FROM `basic_public_site` AS cs
//    INNER JOIN `basic_public_area_role_site` AS ars ON ars.`se_id`=cs.`site_id`
//    INNER JOIN `basic_public_area_role` AS ar ON ar.`ar_id` = ars.`ar_id`
//    WHERE r_id IN (3)
//    GROUP BY cs.site_id


    @Test
    public void fsbService() {
//        List<FinancialSalesBalance> c = fsbMapper.s();
//        shopMapper.findByListShop();
//        for (FinancialSalesBalance f : c) {
//            for (BasicPublicShop sp : shopMapper.findByListShop()) {
//                if (f.getShopId().equals(sp.getShopId())) {
//                    f.setShopName(sp.getShopName());
//                    break;
//                }
//            }
//        }
//        for (int i = 0; i < c.size(); i++) {
//            System.out.println(c.get(i));
//        }
    }
}
