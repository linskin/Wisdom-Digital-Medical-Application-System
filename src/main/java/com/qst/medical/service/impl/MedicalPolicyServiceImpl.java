package com.qst.medical.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qst.medical.entity.MedicalPolicyEntity;
import com.qst.medical.mapper.MedicalPolicyMapper;
import com.qst.medical.model.MedicalPolicyModel;
import com.qst.medical.param.MedicalPolicyParam;
import com.qst.medical.service.MedicalPolicyService;
import com.qst.medical.util.Msg;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalPolicyServiceImpl implements MedicalPolicyService {

    @Autowired
    MedicalPolicyMapper medicalPolicyMapper;

    public Msg getMedicalPolicyWithPage(MedicalPolicyParam param) {
        PageHelper.startPage(param.getPn(),param.getSize());
        List<MedicalPolicyModel> list = medicalPolicyMapper.getAllPolicy(param);
        PageInfo<MedicalPolicyModel> info = new PageInfo<>(list,5);
        return Msg.success().data("policyInfo",info);
    }

    public Msg saveMedicalPolicy(MedicalPolicyParam param) {
        MedicalPolicyEntity mpEntity = new MedicalPolicyEntity();
        BeanUtils.copyProperties(param,mpEntity);
        int i = medicalPolicyMapper.saveMedicalPolicy(mpEntity);
        List<MedicalPolicyModel> allPolicy = medicalPolicyMapper.getAllPolicy(null);
        mpEntity.setTotal((long) allPolicy.size());
        if (i > 0) {
            Long num = mpEntity.getTotal() % 5 == 0 ? (mpEntity.getTotal() / 5) : (mpEntity.getTotal() / 5)+1;
            return Msg.success().mess("添加成功").data("numberOfAdd",i).data("pages",num);
        }
        return Msg.fail().mess("添加失败");
    }

    public Msg updateMedicalPolicy(Long id, MedicalPolicyParam param) {
        MedicalPolicyEntity mpEntity = new MedicalPolicyEntity();
        BeanUtils.copyProperties(param, mpEntity);
        mpEntity.setId(id);
        int i = medicalPolicyMapper.updateMedicalPolicy(mpEntity);
        if (i > 0) {
            return Msg.success().mess("修改成功").data("updateData",mpEntity);
        }
        return Msg.fail().mess("修改失败");
    }

    public Msg deleteMedicalPolicy(Long id) {
        int i = medicalPolicyMapper.deleteMedicalPolicy(id);
        if (i > 0) {
            return Msg.success().mess("删除成功").data("numberOfMPolicyDelete",i);
        }
        return Msg.fail().mess("删除失败");
    }
}
