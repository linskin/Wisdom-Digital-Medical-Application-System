package com.qst.medical.mapper;

import com.qst.medical.domain.Material;

import java.util.List;

public interface MaterialMapper {

    int insert(Material material);

    int update(Material material);

    int delete(Long id);

    Material selectByPrimaryKey(Long id);

    List<Material> selectList(String keyword);
}
