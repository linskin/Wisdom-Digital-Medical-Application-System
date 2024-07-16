package com.qst.medical.controller;


import com.github.pagehelper.PageInfo;
import com.qst.medical.domain.Doctor;
import com.qst.medical.domain.IDoctor;
import com.qst.medical.service.impl.DoctorServiceImpl;
import com.qst.medical.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Api(tags = "医药公司信息控制器") //该注解是swagger提供的，用于描述接口
@RestController
//该注解是Spring提供的，用于描述控制器，@RestController是@Controller和@ResponseBody的组合注解，响应数据一律返回字符串+@Controller等同于@Component
@RequestMapping("/api/doctors")
public class DoctorController {
    @Autowired
    DoctorServiceImpl doctorServiceImpl;

    @GetMapping
    public Msg getDoctorList(@RequestParam(value = "pn") int pageNum, @RequestParam(value = "size") int pageSize, @RequestParam(value = "keyword", required = false,defaultValue = "") String keyword) {
        if (Objects.equals(keyword, "")){
            System.out.println("pn:" + pageNum + "size:" + pageSize + "name:" + keyword);
            return Msg.success();
        }else {
            PageInfo<IDoctor> list = doctorServiceImpl.getDoctorList(pageNum, pageSize, keyword);
            return Msg.success().data("pageInfo", list);
        }
    }

    @GetMapping("/info")
    public Msg getDoctorInfo() {
        PageInfo<IDoctor> list = doctorServiceImpl.getDoctorList(1, 5, "");
        // 判断分页信息不为空
        if (list!=null && list.getList()!=null && !list.getList().isEmpty()){
            return Msg.success().data("pageInfo", list);
        }
        //若无数据，则返回失败
        return Msg.fail();
    }

}
