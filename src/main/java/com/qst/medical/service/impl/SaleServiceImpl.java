package com.qst.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qst.medical.domain.Sale;
import com.qst.medical.entity.SaleEntity;
import com.qst.medical.mapper.SaleMapper;
import com.qst.medical.service.SaleService;
import com.qst.medical.util.Msg;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleMapper saleMapper;

    public PageInfo<Sale> getSaleWithPage(Integer pn, Integer size, String name) {
        if (pn == null && size == null) {
            pn = 1;
            size = 0;
        }
        PageHelper.startPage(pn, size);
        List<Sale> list = saleMapper.getAllSale(name);
//        System.out.println(list);
        return new PageInfo<>(list,5);
    }

    public Msg getSaleById(Integer id) {
        Sale sale = saleMapper.getSaleById(id);

        if(sale == null) {
            return Msg.fail().mess("没有找到");
        }
        return Msg.success().data("sale", sale);
    }

    public Msg saveSale(Sale sale) {
        SaleEntity se = new SaleEntity();
        BeanUtils.copyProperties(sale, se);
        try {
            int i = saleMapper.saveSale(se);
            if (i > 0) {
                Long num = se.getTotal() % 5 == 0 ? (se.getTotal() / 5) : (se.getTotal() / 5)+1;
                return Msg.success().data("pages",num).mess("添加成功");
            }
            return Msg.fail().mess("添加失败");
        } catch (Exception e) {
            return Msg.fail().mess("公司编号已经存在");
        }
    }

    public Msg deleteSaleById(Integer id) {
        int i = saleMapper.deleteSaleById(id);
        if (i > 0) {
            return Msg.success().mess("删除成功");
        } else {
            return Msg.fail().mess("删除失败");
        }
    }

    public Msg updateSaleById(Long id, Sale sale) {
        sale.setSaleId(id);
        int i = saleMapper.updateSaleById(sale);
        if (i > 0) {
            return Msg.success().mess("修改成功");
        }
        return Msg.fail().mess("修改失败");
    }

    @Override
    public int getSaleTableSize() {
        return saleMapper.getSize();
    }


}