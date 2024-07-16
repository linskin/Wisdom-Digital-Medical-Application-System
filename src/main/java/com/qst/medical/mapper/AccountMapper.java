package com.qst.medical.mapper;

import com.qst.medical.entity.AccountEntity;
import com.qst.medical.model.AccountModel;
import org.springframework.stereotype.Component;


/**
 * admin数据访问接口
 *
 * @author liulindong
 * @since 2021年8月17日13:33:15
 */
@Component//其实不用写，在MedicalApplication类中已经配置了扫描，所以可以不写
public interface AccountMapper {

    /*用户登录*/
    AccountModel login(String uname, String encrypt);

    /*注册账号*/
    int regist(AccountEntity entity);

    /*校验手机号存在*/
    int checkPhone(String phone);

    /*更新账户信息*/
    int updateAccount(AccountEntity entity);

    /*根据id删除账户信息*/
    int deleteAccountById(Long id);

    /*用户登录security*/
    AccountModel securityLogin(String uname);

    /*重置密码*/
    int resetPwd(Long id, String pwd);

    /*查询用户的角色*/
    String selectRole();
}