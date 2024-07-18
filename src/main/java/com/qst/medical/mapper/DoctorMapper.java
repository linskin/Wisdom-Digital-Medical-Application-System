package com.qst.medical.mapper;

import com.qst.medical.domain.Doctor;
import com.qst.medical.model.DoctorLevelModel;
import com.qst.medical.model.TreatTypeModel;

import java.io.Serializable;
import java.util.List;

public interface DoctorMapper{

//    @Override
    int insert(Doctor doctor);

//    @Override
    int update(Doctor doctor);

//    @Override
    int delete(Long id);

//    @Override
    Doctor selectByPrimaryKey(Serializable id);

    List<Doctor> selectDoctorList(String keyword);

    List<TreatTypeModel> getAllTreatType();

    List<DoctorLevelModel> getAllLevel();
}
