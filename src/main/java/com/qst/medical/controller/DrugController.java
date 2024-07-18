package com.qst.medical.controller;

import com.github.pagehelper.PageInfo;
import com.qst.medical.model.DrugModel;
import com.qst.medical.param.DrugParam;
import com.qst.medical.service.impl.DrugServiceImpl;
import com.qst.medical.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@Api(tags = "药品控制器类")
@RestController
@RequestMapping("/api/drugs")
public class DrugController {

    @Autowired
    private DrugServiceImpl drugService;

    @GetMapping("/{pn}/{size}")
    public Msg getDrugWithPage(@PathVariable("pn") int pn, @PathVariable("size") int size, @RequestParam(required = false) String name) {
        PageInfo<DrugModel> info = drugService.getDrugWithPage(pn, size, name);
        if (info != null) {
            return Msg.success().data("drugPageInfo",info);
        }
        return Msg.fail();
    }

    @RolesAllowed({"1","2"})
    @PostMapping(value = "")
    public Msg saveDrug(@RequestBody DrugParam drugParam) {
        return drugService.saveDrug(drugParam);
    }

    @RolesAllowed({"1"})
    @PutMapping(value = "/{id}")
    public Msg updateDrug(@PathVariable("id") Long id, @RequestBody DrugParam drugParam) {
        return drugService.updateDrug(id,drugParam);
    }

    @RolesAllowed({"1"})
    @DeleteMapping(value = "/{drugId}")
    public Msg deleteDrug(@PathVariable("drugId") Long drugId) {
        return drugService.deleteDrug(drugId);
    }

}

