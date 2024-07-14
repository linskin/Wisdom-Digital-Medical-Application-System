package com.qst.medical.model;

/**
 * @description: 返回给前端用户信息
 * @author: liulindong
 * @create: 2021/9/2 9:52
 **/
public class AccountInfoModel {
    private String realname;
    private String utype;

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getUtype() {
        return utype;
    }

    public void setUtype(String utype) {
        this.utype = utype;
    }
}
