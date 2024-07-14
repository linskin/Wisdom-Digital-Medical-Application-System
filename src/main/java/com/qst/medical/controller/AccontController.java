package com.qst.medical.controller;

import com.qst.medical.service.AccountService;
import com.qst.medical.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

/**
 * @description: 账户控制器类
 * @author: liulindong
 * @create: 2021/9/3 11:28
 **/
@Api(tags = "账户控制类")
@RestController
@RequestMapping("/api/accounts")
public class AccontController {

    @Autowired
    private AccountService accountService;

    @RolesAllowed({"1"})
    @PutMapping("/{id}")
    public Msg resetPwd(@PathVariable("id") Long id) {
        return accountService.resetPwd(id);
    }
}
