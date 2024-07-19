package com.qst.medical.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qst.medical.domain.Doctor;
import com.qst.medical.entity.AccountEntity;
import com.qst.medical.mapper.AccountMapper;
import com.qst.medical.mapper.DoctorMapper;
import com.qst.medical.model.DoctorLevelModel;
import com.qst.medical.model.TreatTypeModel;
import com.qst.medical.service.DoctorService;
import com.qst.medical.util.MD5;
import com.qst.medical.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorMapper doctorMapper;
    @Autowired
    AccountMapper accountMapper;

    public PageInfo<Doctor> getDoctorList(int pageNum, int pageSize, String keyword) {
        //开始分页查询，原理是在sql语句后加上limit关键字
        PageHelper.startPage(pageNum, pageSize);
        List<Doctor> list = doctorMapper.selectDoctorList(keyword);
        return new PageInfo<>(list);
    }

    @RolesAllowed("1")
    public int addDoctor(Doctor doctor) {
        AccountEntity accountEntity = new AccountEntity();

        accountEntity.setRealname(doctor.getName());

        String phoneNumber = doctor.getPhoneNumber();

        accountEntity.setPhoneNumber(phoneNumber);
        accountEntity.setUname(doctor.getName()+phoneNumber.substring(phoneNumber.length() - 4));
        accountEntity.setPwd(new BCryptPasswordEncoder().encode(doctor.getPwd()));
        accountEntity.setUtype("ROLE_2");

        if (accountMapper.checkPhone(accountEntity.getPhoneNumber()) > 0) {
            return -1;
        }else if (accountMapper.regist(accountEntity) > 0) {
            Long id = accountMapper.selectIdByPhone(phoneNumber);
            doctor.setAccountId(id);
            int i = doctorMapper.insert(doctor);
            if (i > 0){
                return 1;
            }else {
                //医生添加失败，则同步删除账号
                accountMapper.deleteAccountById(id);
                return -1;
            }
        }
        return -1;
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

    public Msg getDoctorLevelAndType() {
        List<TreatTypeModel> allTreatTvpe = doctorMapper.getAllTreatType();
        List<DoctorLevelModel> allLevel = doctorMapper.getAllLevel();
        if (!allLevel.isEmpty() && !allTreatTvpe.isEmpty()){
            return Msg.success().data("allTreatType",allTreatTvpe).data("allLevel",allLevel);
        }
        //若无数据，则返回失败
        return Msg.fail();
    }
}
