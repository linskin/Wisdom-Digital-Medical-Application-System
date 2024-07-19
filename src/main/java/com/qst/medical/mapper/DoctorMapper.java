package com.qst.medical.mapper;

import com.qst.medical.domain.Doctor;
import com.qst.medical.model.DoctorLevelModel;
import com.qst.medical.model.TreatTypeModel;

import java.util.List;

public interface DoctorMapper{


    int insert(Doctor doctor);


    int update(Doctor doctor);


    int delete(Long id);

    int getSize();

    Doctor selectByPrimaryKey(Long id);

    List<Doctor> getAllDoctorTreatTypeAndLevelId();

    List<Doctor> selectDoctorList(String name);

    List<TreatTypeModel> getAllTreatType();

    List<DoctorLevelModel> getAllLevel();
}
