package com.qst.medical.mapper;

import com.qst.medical.entity.DrugEntity;
import com.qst.medical.model.DrugModel;
import com.qst.medical.model.SaleModel;
import com.qst.medical.param.DrugParam;

import java.util.List;

public interface DrugMapper {

    List<DrugModel> getAllDrug(String name);

    List<SaleModel> getWithSale(Long drugId);

    int saveDrug(DrugParam drugParam);

    int updateDrugById(DrugEntity drugEntity);

    int insertSalePlace(Long drugId, Long[] saleIds);

    int deleteSaleByDrugId(Long drugId);

    int deleteDrugById(Long drugId);

}
