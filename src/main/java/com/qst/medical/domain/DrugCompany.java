package com.qst.medical.domain;


import java.util.Date;

public class DrugCompany {

  private Long companyId;
  private String companyName;
  private String companyPhone;
  private Date updatetime;
  private Date createtime;

  @Override
  public String toString() {
    return "DrugCompany{" +
            "companyId=" + companyId +
            ", companyName='" + companyName + '\'' +
            ", companyPhone='" + companyPhone + '\'' +
            ", updatetime=" + updatetime +
            ", createtime=" + createtime +
            '}';
  }

  public Long getCompanyId() {
    return companyId;
  }

  public void setCompanyId(Long companyId) {
    this.companyId = companyId;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public String getCompanyPhone() {
    return companyPhone;
  }

  public void setCompanyPhone(String companyPhone) {
    this.companyPhone = companyPhone;
  }

  public Date getUpdatetime() {
    return updatetime;
  }

  public void setUpdatetime(Date updatetime) {
    this.updatetime = updatetime;
  }

  public Date getCreatetime() {
    return createtime;
  }

  public void setCreatetime(Date createtime) {
    this.createtime = createtime;
  }
}
