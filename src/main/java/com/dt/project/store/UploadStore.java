package com.dt.project.store;

import com.dt.project.utils.StrUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UploadStore
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/27 9:37
 **/
public class UploadStore {

    /**
     * 设置文件第一行List
     */
    public static List<String> setLineHeadList(String lineHead) {
        List<String> txtHeadList = new ArrayList<>();
        txtHeadList.add(StrUtils.specialUnicode(lineHead));
        return txtHeadList;
    }

    /**
     * 转换List
     *
     * @return
     */
    public static List<String> conversionList(List<String> oldHeadList) {
        List<String> headList = new ArrayList<>();
        //转换下头信息
        for (String anOldHeadList : oldHeadList) {
            String head = StrUtils.specialUnicode(anOldHeadList).replace("\"", "").trim();
            headList.add(head);
            System.out.println(head);
        }
        return headList;
    }

}
