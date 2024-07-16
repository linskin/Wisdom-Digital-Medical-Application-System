package com.qst.medical.mapper;

import com.qst.medical.domain.DrugCompany;

import java.io.Serializable;
import java.util.List;

public interface DrugCompanyMapper extends BaseMapper<DrugCompany>{

    @Override
    int insert(DrugCompany drugCompany);

    @Override
    int update(DrugCompany drugCompany);

    @Override
    int delete(DrugCompany drugCompany);

    @Override
    DrugCompany selectByPrimaryKey(Serializable id);

    List<DrugCompany> selectList(String name);
}
