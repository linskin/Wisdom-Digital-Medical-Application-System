package com.qst.medical.mapper;

import com.qst.medical.domain.Doctor;
import com.qst.medical.domain.IDoctor;

import java.io.Serializable;
import java.util.List;

public interface DoctorMapper extends BaseMapper<Doctor>{

    @Override
    int insert(Doctor doctor);

    @Override
    int update(Doctor doctor);

    @Override
    int delete(Doctor doctor);

    @Override
    Doctor selectByPrimaryKey(Serializable id);

    List<IDoctor> selectDoctorList(String keyword);
}
