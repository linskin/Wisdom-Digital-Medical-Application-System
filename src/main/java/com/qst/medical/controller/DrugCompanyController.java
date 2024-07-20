package com.qst.medical.controller;


import com.github.pagehelper.PageInfo;
import com.qst.medical.domain.DrugCompany;
import com.qst.medical.service.impl.DurgCompanyServiceImpl;
import com.qst.medical.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@Api(tags = "医药公司信息控制器") //该注解是swagger提供的，用于描述接口
@RestController //该注解是Spring提供的，用于描述控制器，@RestController是@Controller和@ResponseBody的组合注解，响应数据一律返回字符串+@Controller等同于@Component
@RequestMapping("/api/companys")
public class DrugCompanyController {

    @Autowired
    DurgCompanyServiceImpl drugCompanyService;

    @RolesAllowed({"1"})//只允许一号用户管理新增
    @PostMapping
    public Msg addDrugCompany(@RequestBody DrugCompany company)
    {
//        System.out.println(company);
        int i = drugCompanyService.addDrugCompany(company);
        if (i>0)
        {
            return Msg.success().data("company", company);
        }
        return Msg.fail();
    }

    /**
     * 分页查询医药公司列表
     *
     */
    //@PathVariable表示接受路由传参
    //@RequestParam表示参数可以为空
    @GetMapping("/{pageNum}/{pageSize}")
    public Msg getDrugCompanyList(@PathVariable int pageNum, @PathVariable int pageSize, @RequestParam(value = "name", required = false) String name)
    {
        //分页信息
        PageInfo<DrugCompany> list = drugCompanyService.getDrugCompanyList(pageNum, pageSize, name);
        // 判断分页信息不为空
        if (list!=null && list.getList()!=null && !list.getList().isEmpty()){
            return Msg.success().data("pageInfo", list);
        }
        //若无数据，则返回失败
        return Msg.fail();
    }

    @GetMapping
    public Msg getDrugCompanyList()
    {
        int pageSize = drugCompanyService.getDrugCompanyTableSize();
        //分页信息
        PageInfo<DrugCompany> list = drugCompanyService.getDrugCompanyList(1, pageSize, null);
        // 判断分页信息不为空
        if (list!=null && list.getList()!=null && !list.getList().isEmpty()){
            return Msg.success().data("pageInfo", list);
        }
        //若无数据，则返回失败
        return Msg.fail();
    }

    @RolesAllowed({"1"})
    @PutMapping("/{id}")
    public Msg updateDrugCompany(@PathVariable("id") Long id, @RequestBody DrugCompany company)
    {
        company.setCompanyId(id);
        int i = drugCompanyService.updateDrugCompany(company);
        if (i>0)
        {
            return Msg.success().data("company", company);
        }
        return Msg.fail();
    }

    @RolesAllowed({"1"})
    @DeleteMapping("/{id}")
    public Msg deleteDrugCompany(@PathVariable("id") Long id)
    {
        DrugCompany company = new DrugCompany();
        company.setCompanyId(id);
        int i = drugCompanyService.deleteDrugCompany(company);
        if (i>0)
        {
            return Msg.success();
        }
        return Msg.fail();
    }
}
