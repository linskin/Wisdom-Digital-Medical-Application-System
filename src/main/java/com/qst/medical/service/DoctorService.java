package com.qst.medical.service;

import com.github.pagehelper.PageInfo;
import com.qst.medical.domain.Doctor;
import com.qst.medical.domain.DrugCompany;
import com.qst.medical.domain.IDoctor;

public interface DoctorService {
    PageInfo<IDoctor> getDoctorList(int pageNum, int pageSize, String name);

}
