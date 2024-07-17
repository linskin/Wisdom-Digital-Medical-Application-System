package com.qst.medical.service;

import com.github.pagehelper.PageInfo;
import com.qst.medical.domain.Doctor;

public interface DoctorService {
    PageInfo<Doctor> getDoctorList(int pageNum, int pageSize, String name);

    int addDoctor(Doctor doctor);

    int deleteDoctor(Long id);

    int updateDoctor(Doctor doctor);

    Doctor getDoctorById(Long id);
}
