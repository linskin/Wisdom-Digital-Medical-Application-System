package com.qst.medical.domain;

import com.qst.medical.domain.superdomain.SuperDomain;

/**
 * @description: 封装前端菜单meta里面的属性
 * @author: liulindong
 * @create: 2021/9/2 15:30
 **/
public class Meta extends SuperDomain {
    private String title;//菜单title

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
