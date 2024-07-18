package com.qst.medical.controller;

import com.qst.medical.service.impl.PermissionService;
import com.qst.medical.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 权限菜单控制器
 * @author: liulindong
 * @create: 2021/9/2 0002 15:56
 **/
@Api(tags = "权限菜单控制器")
@RestController
@RequestMapping("/api/permissions")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping(value = "")
    public Msg getAllPermission(String roleName) {
        return Msg.success().data("permissions", permissionService.getAllPermission(roleName));
    }
}
