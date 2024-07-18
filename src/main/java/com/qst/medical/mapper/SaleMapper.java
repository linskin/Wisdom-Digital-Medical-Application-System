package com.qst.medical.mapper;

import com.qst.medical.domain.Sale;
import com.qst.medical.entity.SaleEntity;

import java.util.List;

//@Component
public interface SaleMapper {

    List<Sale> getAllSale(String name);

    Sale getSaleById(Integer id);

    int saveSale(SaleEntity sale);

    int deleteSaleById(Integer id);

    int updateSaleById(Sale sale);
}