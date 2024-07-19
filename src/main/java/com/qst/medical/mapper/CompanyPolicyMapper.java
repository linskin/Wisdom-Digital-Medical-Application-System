package com.qst.medical.mapper;

import com.qst.medical.domain.CompanyPolicy;
import com.qst.medical.entity.CompanyPolicyEntity;
import com.qst.medical.model.CompanyPolicyModel;
import com.qst.medical.model.DrugCompanyModel;
import com.qst.medical.param.CompanyPolicyParam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CompanyPolicyMapper {

    List<CompanyPolicyModel> getAllPolicy(CompanyPolicyParam param);

    List<CompanyPolicy> getPolicyWithCurrentFour();

    int savePolicy(CompanyPolicyEntity entity);

    int updatePolicy(CompanyPolicyEntity entity);

    int deletePolicy(Long id);

    int deletePolicyByCompany(Integer id);

    List<DrugCompanyModel> getCompany();
}