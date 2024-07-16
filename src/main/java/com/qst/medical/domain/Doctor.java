package com.qst.medical.domain;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import java.util.Date;

import com.qst.medical.domain.superdomain.SuperDomain;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

/**
* 
* @TableName doctor
*/
public class Doctor{
    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", levelId=" + levelId +
                ", phone='" + phone + '\'' +
                ", typeId=" + typeId +
                ", hospital='" + hospital + '\'' +
                ", updatetime=" + updatetime +
                ", createtime=" + createtime +
                ", accountId=" + accountId +
                '}';
    }

    /**
    * id(医生信息表)
    */
    @NotNull(message="[id(医生信息表)]不能为空")
    @ApiModelProperty("id(医生信息表)")
    private Long id;
    /**
    * 医生姓名
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("医生姓名")
    @Length(max= 255,message="编码长度不能超过255")
    private String name;
    /**
    * 年龄
    */
    @ApiModelProperty("年龄")
    private Integer age;
    /**
    * 性别：1男，2女
    */
    @ApiModelProperty("性别：1男，2女")
    private Integer sex;
    /**
    * 医师级别id
    */
    @ApiModelProperty("医师级别id")
    private Long levelId;
    /**
    * 联系方式
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("联系方式")
    @Length(max= 255,message="编码长度不能超过255")
    private String phone;
    /**
    * 诊治类别id
    */
    @ApiModelProperty("诊治类别id")
    private Long typeId;
    /**
    * 所属医院
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("所属医院")
    @Length(max= 255,message="编码长度不能超过255")
    private String hospital;
    /**
    * 更新时间
    */
    @ApiModelProperty("更新时间")
    private Date updatetime;
    /**
    * 创建时间
    */
    @ApiModelProperty("创建时间")
    private Date createtime;
    /**
    * 账号id
    */
    @ApiModelProperty("账号id")
    private Long accountId;

    public @NotNull(message = "[id(医生信息表)]不能为空") Long getId() {
        return id;
    }

    public void setId(@NotNull(message = "[id(医生信息表)]不能为空") Long id) {
        this.id = id;
    }

    public @Size(max = 255, message = "编码长度不能超过255") @Length(max = 255, message = "编码长度不能超过255") String getName() {
        return name;
    }

    public void setName(@Size(max = 255, message = "编码长度不能超过255") @Length(max = 255, message = "编码长度不能超过255") String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Long getLevelId() {
        return levelId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }

    public @Size(max = 255, message = "编码长度不能超过255") @Length(max = 255, message = "编码长度不能超过255") String getPhone() {
        return phone;
    }

    public void setPhone(@Size(max = 255, message = "编码长度不能超过255") @Length(max = 255, message = "编码长度不能超过255") String phone) {
        this.phone = phone;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public @Size(max = 255, message = "编码长度不能超过255") @Length(max = 255, message = "编码长度不能超过255") String getHospital() {
        return hospital;
    }

    public void setHospital(@Size(max = 255, message = "编码长度不能超过255") @Length(max = 255, message = "编码长度不能超过255") String hospital) {
        this.hospital = hospital;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
