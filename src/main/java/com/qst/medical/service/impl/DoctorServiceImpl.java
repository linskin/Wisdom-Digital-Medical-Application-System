package com.qst.medical.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qst.medical.domain.Doctor;
import com.qst.medical.entity.AccountEntity;
import com.qst.medical.mapper.DoctorMapper;
import com.qst.medical.service.AccountService;
import com.qst.medical.service.DoctorService;
import com.qst.medical.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorMapper doctorMapper;
    @Autowired
    AccountService accountService;

    public PageInfo<Doctor> getDoctorList(int pageNum, int pageSize, String keyword) {
        //开始分页查询，原理是在sql语句后加上limit关键字
        PageHelper.startPage(pageNum, pageSize);
        List<Doctor> list = doctorMapper.selectDoctorList(keyword);
        return new PageInfo<>(list);
    }

    public int addDoctor(Doctor doctor) {
        AccountEntity accountEntity = new AccountEntity();

        accountEntity.setRealname(doctor.getName());

        String phoneNumber = doctor.getPhoneNumber();

        accountEntity.setPhoneNumber(phoneNumber);
        accountEntity.setUname(doctor.getName()+phoneNumber.substring(phoneNumber.length() - 4));
        accountEntity.setPwd(MD5.encrypt(doctor.getPwd()));
        accountEntity.setUtype("ROLE_2");

        accountService.doctorRegister(accountEntity);//创建账号

        doctor.setAccountId(accountService.selectIdByPhone(phoneNumber));

        return doctorMapper.insert(doctor);
    }

//    @Override

    public int deleteDoctor(Long id) {
        return doctorMapper.delete(id);
    }

    public int updateDoctor(Doctor doctor) {
        return doctorMapper.update(doctor);
    }

    public Doctor getDoctorById(Long id) {
        return doctorMapper.selectByPrimaryKey(id);
    }

}
