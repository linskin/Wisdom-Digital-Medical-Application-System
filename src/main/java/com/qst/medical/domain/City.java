package com.qst.medical.domain;

import java.util.Date;

/**
* 
* @TableName city
*/
public class City{

    private Long cityId;//城市id
    private Integer cityNumber;//城市编号
    private Date createtime;//创建时间
    private Date updatetime;//修改时间

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Integer getCityNumber() {
        return cityNumber;
    }

    public void setCityNumber(Integer cityNumber) {
        this.cityNumber = cityNumber;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }


}
