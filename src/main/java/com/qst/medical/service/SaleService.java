package com.qst.medical.service;

import com.github.pagehelper.PageInfo;
import com.qst.medical.domain.Sale;
import com.qst.medical.util.Msg;

public interface SaleService {


    PageInfo<Sale> getSaleWithPage(Integer pn, Integer size, String name);

    Msg getSaleById(Integer id);

    Msg saveSale(Sale sale) ;

    Msg deleteSaleById(Integer id);


    Msg updateSaleById(Long id, Sale sale);
}