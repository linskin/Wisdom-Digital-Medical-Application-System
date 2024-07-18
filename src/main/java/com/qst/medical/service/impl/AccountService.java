package com.qst.medical.service.impl;

import com.qst.medical.entity.AccountEntity;
import com.qst.medical.mapper.AccountMapper;
import com.qst.medical.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @description: 账户业务逻辑类
 * @author: liulindong
 * @create: 2021/9/3 11:25
 **/
@Service
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;

    /**
     * 重置账号密码
     * @param id
     * @return
     */
    public Msg resetPwd(Long id) {
        String newPwd = new BCryptPasswordEncoder().encode("666666");
        int i = accountMapper.resetPwd(id,newPwd);
        if (i > 0) {
            return Msg.success().mess("重置成功");
        }
        return Msg.fail().mess("重置失败");
    }

    public Msg doctorRegister(AccountEntity accountEntity) {
        if (accountMapper.checkPhone(accountEntity.getPhoneNumber()) > 0) {
            return Msg.fail().mess("该手机号已被注册");
        }else if (accountMapper.regist(accountEntity) > 0) {
                return Msg.success().mess("医生账号注册成功");
            }
        return Msg.fail();
    }

    public long selectIdByPhone(String phone) {
        return accountMapper.selectIdByPhone(phone);
    }
}
