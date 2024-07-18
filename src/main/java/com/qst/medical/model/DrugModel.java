package com.qst.medical.model;

import com.qst.medical.domain.Drug;

import java.util.List;

public class DrugModel extends Drug {

    private List<SaleModel> drugSales;//销售该药的药店地址（集合类型，有多个）

    private String drugSale;//销售该药的药店地址（字符串类型，有多个）

    public List<SaleModel> getDrugSales() {
        return drugSales;
    }

    public void setDrugSales(List<SaleModel> drugSales) {
        this.drugSales = drugSales;
    }

    public String getDrugSale() {
        return drugSale;
    }

    public void setDrugSale(String drugSale) {
        this.drugSale = drugSale;
    }
}
