package com.dt.project;


import com.dt.project.mapper.basePublicMapper.BasicPublicShopMapper;
import com.dt.project.mapper.financialImportMapper.FinancialSalesBalanceMapper;
import com.dt.project.mapper.salesAmazonMapper.SalesShipNoticeMapper;
import com.dt.project.mapper.systemMapper.SystemFinalProcessingMapper;
import com.dt.project.model.FinancialReceivePaymentPrePay;
import com.dt.project.model.JavaSqlName;
import com.dt.project.model.basePublic.BasicPurchaseSupplier;
import com.dt.project.model.purchasePo.*;
import com.dt.project.model.salesAmazon.SalesShipNotice;
import com.dt.project.model.salesAmazon.SalesShipNoticePackingList;
import com.dt.project.service.JavaSqlNameService;
import com.dt.project.utils.DatabaseUtil;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
    @Autowired
    private SalesShipNoticeMapper noticeMapper;


    @Test
    public void add() {
        List<String> tableNames = DatabaseUtil.getTableNames();
        List<String> c = null;
        System.out.println("tableNames:" + tableNames);
        for (String tableName : tableNames) {
            if (tableName.equals("purchase_po_order")) {
                c = DatabaseUtil.getColumnNames(tableName);
            }
        }
        //设置动态查询
        PurchasePoOrder f = new PurchasePoOrder();
        Field[] field = f.getClass().getDeclaredFields();
        for (int i = 0; i < field.length; i++) {
            Field s = field[i];
            s.setAccessible(true);
            System.out.println(s.getName());
            JavaSqlName b = new JavaSqlName();
            b.setjName(s.getName());
            b.setModel("poOrder");
            b.setSqlName(c.get(i));
            service.serviceSet(b);
        }

    }


    @Test
    public void fsbService() throws IOException {
        //1、连接ftp服务器
        FTPClient ftpClient = new FTPClient();
        ftpClient.connect("192.168.1.230", 21);
        //2、登录ftp服务器
        ftpClient.login("ftpuser", "wawzj7788");
        ftpClient.setControlEncoding("UTF-8");
        int reply = ftpClient.getReplyCode();
        System.out.println(reply);
        if (!FTPReply.isPositiveCompletion(reply)) {
            System.out.println("connect failed...ftp服务器");
            ftpClient.disconnect();
            return;
        }
        System.out.println("connect successfu...ftp服务器");
        //4、上传文件
        //1）指定上传目录
        ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
        //2）指定文件类型
        ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
        //3、读取本地文件
        FileInputStream inputStream = new FileInputStream(new File("E:/1.jpg"));
        //第一个参数：文件在远程服务器的名称
        //第二个参数：文件流
        ftpClient.storeFile("hello.jpg", inputStream);
        //5、退出登录
        ftpClient.logout();
    }

    @Test
    public void selectByNotice() {
        noticeMapper.selectByNotice(new SalesShipNotice());
    }
}

