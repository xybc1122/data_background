package com.dt.user.model;

import java.io.Serializable;

public class TbHeadMenu implements Serializable {

  private Long id;
  private Long mid;
  private Long thId;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getMid() {
    return mid;
  }

  public void setMid(Long mid) {
    this.mid = mid;
  }

  public Long getThId() {
    return thId;
  }

  public void setThId(Long thId) {
    this.thId = thId;
  }
}
