package com.qst.medical.service.login;

import com.qst.medical.domain.Account;
import com.qst.medical.mapper.AccountMapper;
import com.qst.medical.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登录、登出业务逻辑处理类
 *
 * @author liulindong
 * @since 2021年8月17日14:31:54
 */
@Service
public class LoginorOutService {

    @Autowired
    private AccountMapper accountMapper;

    /**
     * 用户登录
     * @param uname
     * @param encrypt
     * @return
     */
    public Account login(String uname, String encrypt) {

        return accountMapper.login(uname, MD5.encrypt(encrypt));
    }
}