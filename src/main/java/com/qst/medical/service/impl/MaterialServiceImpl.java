package com.qst.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qst.medical.domain.Material;
import com.qst.medical.mapper.MaterialMapper;
import com.qst.medical.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    MaterialMapper materialMapper;

    public PageInfo<Material> getMaterialList(int pageNum, int pageSize, String keyword) {
        // 开始分页查询，原理在sql语句后面拼接limit
        PageHelper.startPage(pageNum,pageSize);
        List<Material> list = materialMapper.selectList(keyword);
        // 该对象，包含分页的所有信息
        PageInfo<Material> info = new PageInfo<>(list);
        return info;
    }

    public int addMaterial(Material material) {
        return materialMapper.insert(material);
    }

    public int deleteMaterialById(Long Id) {
        return materialMapper.delete(Id);
    }

    public int updMaterial(Material material) {
        return materialMapper.update(material);
    }
}
