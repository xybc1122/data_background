package com.dt.user.store;

import com.dt.user.model.ParentUploadInfo;
import com.dt.user.utils.StrUtils;

/**
 * @ClassName SpliceSqlStore
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/27 8:57
 **/
public class SpliceSqlStore {


    /**
     * 通用拼接set
     *
     * @param sb
     * @param p
     */
    public static void set(StringBuilder sb, ParentUploadInfo p) {
        sb.append(p.getCreateDate()).append(",");
        StrUtils.appBuider(sb, p.getCreateUser());
        sb.append(",");
        sb.append(p.getRecordingId()).append("),");
    }
}
