package com.qst.medical.service;

import com.github.pagehelper.PageInfo;
import com.qst.medical.domain.DrugCompany;
import com.qst.medical.model.DrugCompanyModel;

import java.util.List;

public interface DurgCompanyService {

    PageInfo<DrugCompany> getDrugCompanyList(int pageNum, int pageSize, String name);

    int addDrugCompany(DrugCompany company);

    int deleteDrugCompany(DrugCompany company);

    int updateDrugCompany(DrugCompany company);

    List<DrugCompanyModel> getAllDrugCompany();
}
