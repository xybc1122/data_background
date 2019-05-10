package com.dt.user.provider;

import com.dt.user.model.SystemLogStatus;
import com.dt.user.store.SystemLogStatusStore;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * @ClassName SystemLogStatusProvider
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/11 10:18
 **/
public class SystemLogStatusProvider {

    public String upLogStatusPro(SystemLogStatus logStatus) {
        return new SQL() {{
            UPDATE("`system_log_status`");
            //备注
            if (StringUtils.isNotBlank(logStatus.getRemark())) {
                SET("remark=#{remark}");
            }
            //状态
            if (logStatus.getStatus() != null) {
                SET("status=#{status}");
            }
            //创建时间
            if (logStatus.getCreateDate() != null) {
                SET("create_date=#{createDate}");
            }
            //创建人
            if (StringUtils.isNotBlank(logStatus.getCreateUser())) {
                SET("create_user=#{createUser}");
            }
            //修改日期
            if (logStatus.getModifyDate() != null) {
                SET("modify_date=#{modifyDate}");
            }
            //修改人
            if (StringUtils.isNotBlank(logStatus.getModifyUser())) {
                SET("modify_user=#{modifyUser}");
            }
            //审核时间
            if (logStatus.getAuditDate() != null) {
                SET("audit_date=#{auditDate}");
            }
            //审核人
            if (logStatus.getAuditUser() != null) {
                SET("audit_user=#{auditUser}");
            }

            WHERE("status_id=#{statusId}");
        }}.toString();
    }

    public String delLogStatusPro(Map<String, Object> mapDel) {
        String warIds = mapDel.get("statusIds").toString();
        return SystemLogStatusStore.logStatusUpdate(warIds);
    }
}
