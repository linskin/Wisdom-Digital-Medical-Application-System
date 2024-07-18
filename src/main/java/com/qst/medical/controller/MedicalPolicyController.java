package com.qst.medical.controller;


import com.qst.medical.param.MedicalPolicyParam;
import com.qst.medical.service.impl.MedicalPolicyServiceImpl;
import com.qst.medical.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.security.RolesAllowed;

@Api(tags = "医保政策信息控制器")
@RestController
@RequestMapping("/api/medical_policys")
public class MedicalPolicyController {
    @Autowired
    private MedicalPolicyServiceImpl medicalPolicyService;

    @GetMapping
    public Msg getMedicalPolicyWithPage(MedicalPolicyParam param) {
        Msg msg = medicalPolicyService.getMedicalPolicyWithPage(param);
        return msg;

    }

    @RolesAllowed({"1"})
    @PostMapping
    public Msg saveMedicalPolicy(@RequestBody MedicalPolicyParam medicalPolicy) {
        return medicalPolicyService.saveMedicalPolicy(medicalPolicy);

    }

    @RolesAllowed({"1"})
    @PutMapping(value = "/{id}")
    public Msg updateMedicalPolicy(@PathVariable("id") Long id, @RequestBody MedicalPolicyParam param) {
        if (!StringUtils.hasLength(param.getTitle())) {
            return Msg.fail().mess("标题不能为空");
        }
        if (!StringUtils.hasLength(param.getMessage())) {
            return Msg.fail().mess("内容不能为空");
        }
        if (param.getCityId() == null) {
            return Msg.fail().mess("城市不能为空");
        }
        return medicalPolicyService.updateMedicalPolicy(id, param);
    }

    @RolesAllowed({"1"})
    @DeleteMapping("/{id}")
    public Msg deleteMedicalPolicy(@PathVariable("id") Long id) {
        Msg msg = medicalPolicyService.deleteMedicalPolicy(id);
        return msg;
    }
}
