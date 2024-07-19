package com.qst.medical.controller;


import com.github.pagehelper.PageInfo;
import com.qst.medical.domain.Doctor;
import com.qst.medical.service.impl.AccountServiceImpl;
import com.qst.medical.service.impl.DoctorServiceImpl;
import com.qst.medical.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "医药公司信息控制器") //该注解是swagger提供的，用于描述接口
@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    @Autowired
    DoctorServiceImpl doctorServiceImpl;
    @Autowired
    AccountServiceImpl accountService;

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
        return doctorServiceImpl.getDoctorLevelAndType();
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

    @PutMapping("/reset/{id}")
    public Msg resetPwd(@PathVariable("id") Long id) {
        return accountService.resetPwd(id);
    }

    @DeleteMapping("{id}")
    public Msg deleteDoctor(@PathVariable("id") Long id) {
        if (doctorServiceImpl.deleteDoctor(id) > 0) {
            return Msg.success().mess("Delete doctor successfully");
        }
        return Msg.fail().mess("Delete doctor failed");
    }
}
