package com.qst.medical.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qst.medical.domain.Doctor;
import com.qst.medical.domain.IDoctor;
import com.qst.medical.mapper.DoctorMapper;
import com.qst.medical.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    DoctorMapper doctorMapper;


    public PageInfo<IDoctor> getDoctorList(int pageNum, int pageSize, String keyword) {
        //开始分页查询，原理是在sql语句后加上limit关键字
        PageHelper.startPage(pageNum, pageSize);
        List<IDoctor> list = doctorMapper.selectDoctorList(keyword);
        return new PageInfo<>(list);
    }

    public int addDoctor(Doctor doctor) {
        return doctorMapper.insert(doctor);
    }

    public int deleteDoctor(Doctor doctor) {
        return doctorMapper.delete(doctor);
    }

    public int updateDoctor(Doctor doctor) {
        return doctorMapper.update(doctor);
    }

    public Doctor getDoctorById(Long id) {
        return doctorMapper.selectByPrimaryKey(id);
    }

}
