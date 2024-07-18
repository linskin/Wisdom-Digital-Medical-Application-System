package com.qst.medical.mapper;

import com.qst.medical.domain.DrugCompany;
import com.qst.medical.model.DrugCompanyModel;

import java.io.Serializable;
import java.util.List;

public interface DrugCompanyMapper{


    int insert(DrugCompany drugCompany);


    int update(DrugCompany drugCompany);


    int delete(DrugCompany drugCompany);

    int getSize();

    DrugCompany selectByPrimaryKey(Serializable id);

    List<DrugCompany> selectList(String name);

    List<DrugCompanyModel> selectAll();
}
