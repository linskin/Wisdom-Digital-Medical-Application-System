package com.qst.medical.service.impl;

import com.qst.medical.domain.DashBoard;
import com.qst.medical.domain.Doctor;
import com.qst.medical.mapper.*;
import com.qst.medical.service.DashBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class DashBoardServiceImpl implements DashBoardService {

    @Autowired
    private DoctorMapper doctorMapper;
    @Autowired
    private DrugMapper drugMapper;
    @Autowired
    private DrugCompanyMapper drugCompanyMapper;
    @Autowired
    private SaleMapper saleMapper;
    @Autowired
    private MedicalPolicyMapper medicalPolicyMapper;
    @Qualifier("companyPolicyMapper")
    @Autowired
    private CompanyPolicyMapper companyPolicyMapper;

    public DashBoard getDashboardData(){
        DashBoard dashBoard = new DashBoard();
        dashBoard.setCompanyNumb(drugCompanyMapper.getSize());
        dashBoard.setDrugNumb(drugMapper.getSize());
        dashBoard.setDoctorNumb(doctorMapper.getSize());
        dashBoard.setSaleNumb(saleMapper.getSize());
        //所有医生信息
        List<Doctor> allDoctorTreatTypeAndLevelId = doctorMapper.getAllDoctorTreatTypeAndLevelId();
        //诊治部位的HashMap
        HashMap<String, Integer> doctorTreatMap = new HashMap<>();
        doctorMapper.getAllTreatType().forEach(treatType -> {
            doctorTreatMap.put(treatType.getName(), 0);
        });

        HashMap<String, Integer> doctorLevelMap = new HashMap<>();
        doctorMapper.getAllLevel().forEach(level -> {
            doctorLevelMap.put(level.getName(), 0);
        });

        int l1=0, l2=0,l3=0;
        for (Doctor doctor : allDoctorTreatTypeAndLevelId) {
            if (doctor.getLevelId()==1){
                l1++;
            }else if (doctor.getLevelId()==2){
                l2++;
            }else if (doctor.getLevelId()==3){
                l3++;
            }
            switch (doctor.getTypeId().intValue()){
                case 1:
                    doctorTreatMap.put("肩部", doctorTreatMap.get("肩部") + 1);
                    break;
                case 2:
                    doctorTreatMap.put("踝部", doctorTreatMap.get("踝部") + 1);
                    break;
                case 3:
                    doctorTreatMap.put("膝部", doctorTreatMap.get("膝部") + 1);
                    break;
                case 9:
                    doctorTreatMap.put("腰部", doctorTreatMap.get("腰部") + 1);
                    break;
                case 10:
                    doctorTreatMap.put("头部", doctorTreatMap.get("头部") + 1);
                    break;
                case 11:
                    doctorTreatMap.put("肘部", doctorTreatMap.get("肘部") + 1);
                    break;
                case 12:
                    doctorTreatMap.put("腿部", doctorTreatMap.get("腿部") + 1);
                    break;

            }
        }
        doctorLevelMap.put("l1", l1);
        doctorLevelMap.put("l2", l2);
        doctorLevelMap.put("l3", l3);

        dashBoard.setDocLevel(doctorLevelMap);//柱状图数据集
        dashBoard.setTreatMap(doctorTreatMap);//饼图数据集
        dashBoard.setMaterials(medicalPolicyMapper.getMaterialWithCurrentFive());
        dashBoard.setPolicys(companyPolicyMapper.getPolicyWithCurrentFour());

        return dashBoard;
    }
}
