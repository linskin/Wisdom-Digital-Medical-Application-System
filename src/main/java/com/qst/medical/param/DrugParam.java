package com.qst.medical.param;

import com.qst.medical.domain.Drug;

public class DrugParam extends Drug {

    private Long[] saleIds;//售卖该药品的药店

    private String publisher;//发布者

    public Long[] getSaleIds() {
        return saleIds;
    }

    public void setSaleIds(Long[] saleIds) {
        this.saleIds = saleIds;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}