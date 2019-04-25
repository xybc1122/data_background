package com.dt.user.model.System;

import com.dt.user.model.Parent.ConfTableParent;

/**
 * 角色店铺配置类
 */
public class SystemShopRole  extends ConfTableParent {
    private Integer sid;

    private Integer rid;

    private Integer rsId;


    public SystemShopRole(Integer rid, Integer sid, Long createDate, String createUser) {
        super(createDate,createUser);
        this.rid = rid;
        this.sid = sid;
    }


    public Integer getSid() {
        return sid;
    }



    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getRsId() {
        return rsId;
    }

    public void setRsId(Integer rsId) {
        this.rsId = rsId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sId=").append(sid);
        sb.append(", rId=").append(rid);
        sb.append(", rsId=").append(rsId);
        sb.append("]");
        return sb.toString();
    }
}