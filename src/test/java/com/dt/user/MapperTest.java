package com.dt.user;


import com.dt.user.mapper.BasePublicMapper.BasicPublicCountryMapper;
import com.dt.user.model.BasePublicModel.BasicPublicCountry;
import com.dt.user.model.JavaSqlName;
import com.dt.user.model.SalesAmazon.SalesAmazonFbaMonthWarehouseFee;
import com.dt.user.service.BasePublicService.BasicPublicProductsService;
import com.dt.user.service.JavaSqlNameService;
import com.dt.user.service.impl.JavaSqlNameServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {
   @Autowired
   private JavaSqlNameService service;

    @Test
    public void add() {
        SalesAmazonFbaMonthWarehouseFee fee = new SalesAmazonFbaMonthWarehouseFee();
        Field[] field = fee.getClass().getDeclaredFields();
        for (Field s : field) {
            s.setAccessible(true);
            JavaSqlName b = new JavaSqlName();
            b.setjName(s.getName());
            b.setModel("monthWarehouseFee");
            service.serviceSet(b);
        }
    }

}
