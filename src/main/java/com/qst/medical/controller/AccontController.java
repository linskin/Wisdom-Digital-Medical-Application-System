package com.qst.medical.controller;

import com.qst.medical.service.impl.AccountServiceImpl;
import com.qst.medical.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

/**
 * &#064;description:  账户控制器类
 * &#064;author:  liulindong
 * &#064;create:  2021/9/3 11:28
 **/
@Api(tags = "账户控制类")
@RestController
@RequestMapping("/api/accounts")
public class AccontController {

    @Autowired
    private AccountServiceImpl accountServiceImpl;

    @RolesAllowed({"1"})
    @PutMapping("/{id}")
    public Msg resetPwd(@PathVariable("id") Long id) {
        return accountServiceImpl.resetPwd(id);
    }
}
