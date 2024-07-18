package com.qst.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qst.medical.entity.DrugEntity;
import com.qst.medical.mapper.DrugMapper;
import com.qst.medical.model.DrugModel;
import com.qst.medical.model.SaleModel;
import com.qst.medical.param.DrugParam;
import com.qst.medical.service.DrugService;
import com.qst.medical.util.Msg;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DrugServiceImpl implements DrugService {

    @Autowired
    private DrugMapper drugMapper;

    public PageInfo<DrugModel> getDrugWithPage(int pn, int size, String name) {
        PageHelper.startPage(pn, size);
        List<DrugModel> list = drugMapper.getAllDrug(name);
        list.forEach(drugModel -> {
            List<SaleModel> i = drugMapper.getWithSale(drugModel.getDrugId());
            drugModel.setDrugSale(i+"");
        });
        return new PageInfo<>(list,5);
    }

    public Msg saveDrug(DrugParam drugParam) {
        int i = drugMapper.saveDrug(drugParam);
        int j = drugMapper.insertSalePlace(drugParam.getDrugId(), drugParam.getSaleIds());
        //由于前端不好判断插入后的总记录数，所以插入之后返回全部的药品数量
        List<DrugModel> allDrug = drugMapper.getAllDrug(null);
        drugParam.setTotal((long) allDrug.size());
        if (i > 0 && j > 0) {
            Long num = drugParam.getTotal() % 5 == 0 ? (drugParam.getTotal() / 5) : (drugParam.getTotal() / 5)+1;
            return Msg.success().data("pages",num).mess("添加成功");
        }
        return Msg.fail().mess("添加失败");
    }

    public Msg updateDrug(Long id, DrugParam drugParam) {
        drugParam.setDrugId(id);
        drugMapper.deleteSaleByDrugId(drugParam.getDrugId());
        drugMapper.insertSalePlace(drugParam.getDrugId(),drugParam.getSaleIds());
        DrugEntity drugEntity = new DrugEntity();
        BeanUtils.copyProperties(drugParam,drugEntity);
        int i = drugMapper.updateDrugById(drugEntity);
        if (i > 0) {
            return Msg.success().mess("修改成功");
        }
        return Msg.fail().mess("修改失败");
    }

    public Msg deleteDrug(Long drugId) {
        int i = drugMapper.deleteDrugById(drugId);
        int j = drugMapper.deleteSaleByDrugId(drugId);
        if (i > 0 && j > 0) {
            return Msg.success().mess("删除成功");
        }
        return Msg.fail().mess("删除失败");
    }

}
