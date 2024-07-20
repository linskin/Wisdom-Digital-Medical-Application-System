package com.qst.medical.controller;

import com.github.pagehelper.PageInfo;
import com.qst.medical.domain.Material;
import com.qst.medical.service.impl.MaterialServiceImpl;
import com.qst.medical.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@Api("必备材料管理器")
@RestController
@RequestMapping("/api/materials")
public class MaterialController {

    @Autowired
    MaterialServiceImpl materialService;

    @RolesAllowed({"1"})
    @GetMapping("")
    public Msg getMaterialList(@RequestParam(name = "pn", defaultValue = "1") int pageNum, @RequestParam(name = "size", defaultValue = "5") int pageSize, @RequestParam String keyword) {

        //分页信息
        PageInfo<Material> list = materialService.getMaterialList(pageNum,pageSize,keyword);

        // 判断分页信息不为空，分页信息里面的数据集合不为空
        if(list != null && list.getList() != null && !list.getList().isEmpty()) {
            //向前端返回匹配格式的数据，该数据团包括主要的数据，还有状态码，响应消息等信息
            return Msg.success().data("materialInfo",list);
        }
        // 若查询出错，无数据返回，则响应失败
        return Msg.fail();
    }

    @RolesAllowed({"1","2"})
    @PostMapping
    public Msg addMaterial(@RequestBody Material material) {
        int i = materialService.addMaterial(material);
        if(i > 0) {
            return Msg.success().mess("添加成功！");
        }
        return Msg.fail();
    }

    @RolesAllowed({"1","2"})
    @DeleteMapping("/{id}")
    public Msg delMaterial(@PathVariable Long id) {
        int i = materialService.deleteMaterialById(id);
        return i > 0 ? Msg.success().mess("删除成功！") : Msg.fail();
    }

    @RolesAllowed({"1","2"})
    @PutMapping("/{id}")
    public Msg updMaterial(@RequestBody Material material, @PathVariable Long id) {
        material.setId(id);
        int i = materialService.updMaterial(material);
        if (i > 0){
            return Msg.success().data("material",material);
        }else {
            return Msg.fail().mess("修改失败！");
        }
    }
}