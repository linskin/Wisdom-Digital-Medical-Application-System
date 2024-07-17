package com.qst.medical.controller;


import com.github.pagehelper.PageInfo;
import com.qst.medical.domain.Doctor;
import com.qst.medical.mapper.DoctorMapper;
import com.qst.medical.model.DoctorLevelModel;
import com.qst.medical.model.TreatTypeModel;
import com.qst.medical.service.impl.DoctorServiceImpl;
import com.qst.medical.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "医药公司信息控制器") //该注解是swagger提供的，用于描述接口
@RestController
//该注解是Spring提供的，用于描述控制器，@RestController是@Controller和@ResponseBody的组合注解，响应数据一律返回字符串+@Controller等同于@Component
@RequestMapping("/api/doctors")
public class DoctorController {
    @Autowired
    DoctorServiceImpl doctorServiceImpl;
    @Autowired
    private DoctorMapper doctorMapper;

    @GetMapping
    public Msg getDoctorInfo(@RequestParam(value = "pn") int pageNum, @RequestParam(value = "size") int pageSize, @RequestParam(value = "keyword", required = false) String keyword) {
        PageInfo<Doctor> list = doctorServiceImpl.getDoctorList(pageNum, pageSize, keyword);
        if (list!=null && list.getList()!=null && !list.getList().isEmpty()){
            return Msg.success().data("doctorInfo", list);
        }
        return Msg.fail().mess("No doctors found");
    }

    @GetMapping("/info")
    public Msg getDoctorLevelAndType() {
        List<TreatTypeModel> allTreatTvpe = doctorMapper.getAllTreatType();
        List<DoctorLevelModel> allLevel = doctorMapper.getAllLevel();
        // 判断分页信息不为空
        if (!allLevel.isEmpty() && !allTreatTvpe.isEmpty()){
            return Msg.success().data("allTreatType",allTreatTvpe).data("allLevel",allLevel);
        }
        //若无数据，则返回失败
        return Msg.fail();
    }

    @PostMapping
    public Msg addDoctor(@RequestBody Doctor doctor) {
        if (doctor == null){
            return Msg.fail().mess("Doctor info is null");
        }
        int i = doctorServiceImpl.addDoctor(doctor);
        if (i > 0) {
            return Msg.success().mess("Add doctor successfully");
        }
        return Msg.fail();
    }

    @PutMapping("{id}")
    public Msg updateDoctor(@PathVariable("id") Long id, @RequestBody Doctor doctor) {
        if (doctor == null){
            return Msg.fail().mess("Doctor info is null");
        }
        doctor.setId(id);
        if (doctorServiceImpl.updateDoctor(doctor) > 0) {
            return Msg.success().mess("Update doctor successfully");
        }
        return Msg.fail().mess("Update doctor failed");
    }

    @DeleteMapping("{id}")
    public Msg deleteDoctor(@PathVariable("id") Long id) {
        if (doctorServiceImpl.deleteDoctor(id) > 0) {
            return Msg.success().mess("Delete doctor successfully");
        }
        return Msg.fail().mess("Delete doctor failed");
    }
}
