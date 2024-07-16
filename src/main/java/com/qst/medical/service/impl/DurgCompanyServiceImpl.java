package com.qst.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qst.medical.domain.DrugCompany;
import com.qst.medical.mapper.DrugCompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DurgCompanyServiceImpl {

    @Autowired//自动注入
    DrugCompanyMapper drugCompanyMapper;

    /**
     * 分页模糊查询医药公司集合
     *
     * @param pageNum
     * @param pageSize
     * @param name
     * @return
     */


    public PageInfo<DrugCompany> getDrugCompanyList(int pageNum, int pageSize, String name) {
        //开始分页查询，原理是在sql语句后加上limit关键字
        PageHelper.startPage(pageNum, pageSize);
        List<DrugCompany> list = drugCompanyMapper.selectList(name);
//        System.out.println(list);
//        System.out.println(new PageInfo<>(list));
        // 该对象包含分页的所有信息
        return new PageInfo<>(list);
    }

    public int addDrugCompany(DrugCompany company) {
//        Date now = new Date();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        company.setCreatetime(now);
//        company.setUpdatetime(now.format(formatter));
        //        company.getCompanyId();
//        company.getCompanyPhone();
        return drugCompanyMapper.insert(company);
    }

    public int deleteDrugCompany(DrugCompany company) {
        return drugCompanyMapper.delete(company);
    }

    public int updateDrugCompany(DrugCompany company) {
        return drugCompanyMapper.update(company);
    }
}
