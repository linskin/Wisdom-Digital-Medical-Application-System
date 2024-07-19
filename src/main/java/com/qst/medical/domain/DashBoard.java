package com.qst.medical.domain;

import java.util.HashMap;
import java.util.List;

public class DashBoard {
    private Integer doctorNumb;
    private Integer drugNumb;
    private Integer companyNumb;
    private Integer saleNumb;
    private HashMap<String,Integer> docLevel;//医生级别人数
    private HashMap<String,Integer> treatMap;//诊治部位医生人数
    private List<Material> materials;//报销必备材料
    //医药公司政策
    private List<CompanyPolicy> policys;

    @Override
    public String toString() {
        return "DashBoard{" +
                "doctorNumb=" + doctorNumb +
                ", drugNumb=" + drugNumb +
                ", companyNum=" + companyNumb +
                ", saleNumb=" + saleNumb +
                ", docLevel=" + docLevel +
                ", treatMap=" + treatMap +
                ", materials=" + materials +
                ", policys=" + policys +
                '}';
    }

    public Integer getDoctorNumb() {
        return doctorNumb;
    }

    public void setDoctorNumb(Integer doctorNumb) {
        this.doctorNumb = doctorNumb;
    }

    public Integer getDrugNumb() {
        return drugNumb;
    }

    public void setDrugNumb(Integer drugNumb) {
        this.drugNumb = drugNumb;
    }

    public Integer getCompanyNumb() {
        return companyNumb;
    }

    public void setCompanyNumb(Integer companyNumb) {
        this.companyNumb = companyNumb;
    }

    public Integer getSaleNumb() {
        return saleNumb;
    }

    public void setSaleNumb(Integer saleNumb) {
        this.saleNumb = saleNumb;
    }

    public HashMap<String, Integer> getDocLevel() {
        return docLevel;
    }

    public void setDocLevel(HashMap<String, Integer> docLevel) {
        this.docLevel = docLevel;
    }

    public HashMap<String, Integer> getTreatMap() {
        return treatMap;
    }

    public void setTreatMap(HashMap<String, Integer> treatMap) {
        this.treatMap = treatMap;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    public List<CompanyPolicy> getPolicys() {
        return policys;
    }

    public void setPolicys(List<CompanyPolicy> policys) {
        this.policys = policys;
    }
}
