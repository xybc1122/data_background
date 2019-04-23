package com.dt.user;


import com.dt.user.mapper.SystemMapper.SystemFinalProcessingMapper;
import com.dt.user.model.JavaSqlName;
import com.dt.user.model.SalesAmazon.SalesAmazonFbaReview;
import com.dt.user.service.JavaSqlNameService;
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
    @Autowired
    private SystemFinalProcessingMapper pMapper;

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

    @Test
    public void selectByExample() {

    }
}
