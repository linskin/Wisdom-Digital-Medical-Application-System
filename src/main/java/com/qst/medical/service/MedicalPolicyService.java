package com.qst.medical.service;

import com.qst.medical.domain.MedicalPolicy;
import com.qst.medical.param.MedicalPolicyParam;
import com.qst.medical.util.Msg;

public interface MedicalPolicyService {
    public Msg getMedicalPolicyWithPage(MedicalPolicyParam param);
    public Msg saveMedicalPolicy(MedicalPolicyParam param);
    public Msg updateMedicalPolicy(Long id, MedicalPolicyParam param);
    public Msg deleteMedicalPolicy(Long id);
}
