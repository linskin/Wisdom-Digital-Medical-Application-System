package com.qst.medical.model;

public class DrugCompanyModel{
    private Long companyId;
    private String companyName;


    public String toString() {
        return "DrugCompanyModel{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                '}';
    }


    public String getCompanyName() {
        return companyName;
    }


    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


    public Long getCompanyId() {
        return companyId;
    }


    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
