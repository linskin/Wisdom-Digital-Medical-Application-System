package com.qst.medical.domain;

import com.qst.medical.domain.superdomain.SuperDomain;

import java.util.Date;

public class Drug extends SuperDomain {
    private Long drugId;//药品id

    private String drugName;//药品名称

    private String drugInfo;//药品成分信息

    private String drugEffect;//药品功能作用

    private String drugImg;//药品图片url

    private Date createtime;//药品创建时间

    private Date updatetime;//药品更新时间

    private String drugPublisher;//药品发布者

    public Long getDrugId() {
        return drugId;
    }

    public void setDrugId(Long drugId) {
        this.drugId = drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugInfo() {
        return drugInfo;
    }

    public void setDrugInfo(String drugInfo) {
        this.drugInfo = drugInfo;
    }

    public String getDrugEffect() {
        return drugEffect;
    }

    public void setDrugEffect(String drugEffect) {
        this.drugEffect = drugEffect;
    }

    public String getDrugImg() {
        return drugImg;
    }

    public void setDrugImg(String drugImg) {
        this.drugImg = drugImg;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getDrugPublisher() {
        return drugPublisher;
    }

    public void setDrugPublisher(String drugPublisher) {
        this.drugPublisher = drugPublisher;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "drugId=" + drugId +
                ", drugName='" + drugName + '\'' +
                ", drugInfo='" + drugInfo + '\'' +
                ", drugEffect='" + drugEffect + '\'' +
                ", drugImg='" + drugImg + '\'' +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", drugPublisher='" + drugPublisher + '\'' +
                '}';
    }
}