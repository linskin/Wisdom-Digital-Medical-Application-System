package com.qst.medical.service;

import com.github.pagehelper.PageInfo;
import com.qst.medical.domain.Material;

public interface MaterialService {
    PageInfo<Material> getMaterialList(int pageNum, int pageSize, String keyword);

    int addMaterial(Material material);

    int deleteMaterialById(Long Id);

    int updMaterial(Material material);
}
