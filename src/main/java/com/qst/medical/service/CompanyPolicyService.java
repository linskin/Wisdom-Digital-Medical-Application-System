package com.qst.medical.service;

import com.qst.medical.model.CompanyPolicyModel;
import com.qst.medical.param.CompanyPolicyParam;
import com.qst.medical.util.Msg;

import java.util.List;

public interface CompanyPolicyService {

    Msg getAllPolicyWithPage(CompanyPolicyParam param);

    Msg savePolicy(CompanyPolicyParam param);

    Msg updatePolicy(Long id, CompanyPolicyParam param);

    Msg deletePolicy(Long id);

    List<CompanyPolicyModel> getFirstPolicyWithPage();
}
