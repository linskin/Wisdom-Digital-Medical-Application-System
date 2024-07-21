package com.qst.medical.mapper;

import com.qst.medical.domain.Material;
import com.qst.medical.entity.MedicalPolicyEntity;
import com.qst.medical.model.MedicalPolicyModel;
import com.qst.medical.param.MedicalPolicyParam;

import java.util.List;

public interface MedicalPolicyMapper {

    List<MedicalPolicyModel> getAllPolicy(MedicalPolicyParam param);

    int saveMedicalPolicy(MedicalPolicyEntity param);

    int updateMedicalPolicy(MedicalPolicyEntity param);

    int deleteMedicalPolicy(Long id);

    int deleteByCity(Integer city);

    List<Material> getMaterialWithCurrentFive();
}
