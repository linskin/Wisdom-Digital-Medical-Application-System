package com.qst.medical.service;

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
}
