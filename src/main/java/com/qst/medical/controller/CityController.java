package com.qst.medical.controller;

import com.github.pagehelper.PageInfo;
import com.qst.medical.model.CityModel;
import com.qst.medical.service.impl.CityServiceImpl;
import com.qst.medical.util.Msg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@Api(tags = "城市信息控制器")
@RestController
@RequestMapping("/api/citys")
public class CityController {

    @Autowired
    private CityServiceImpl cityService;

    @GetMapping(value = {"/{pn}/{size}",""})
    public Msg getCityWithPage(@PathVariable(value = "pn",required = false) Integer pn,
                               @PathVariable(value = "size",required = false) Integer size,
                               @RequestParam(required = false) String name) {
        PageInfo<CityModel> info = cityService.getCityWithPage(pn, size, name);
        if (info != null) {
            return Msg.success().data("cityPageInfo",info);
        }
        return Msg.fail();
    }
    @GetMapping("{id}")
    public Msg getCityById(@PathVariable("id") Integer id) {
        Msg msg = cityService.getCityById(id);
        return msg;
    }

    @RolesAllowed({"1"})
    @PostMapping(value = "")
    public Msg insertCity(Integer cityNumber) {
        if (cityService.checkCityByName(cityNumber) > 0) {
            return Msg.fail().mess("城市已经存在").code(10004);
        }
        return cityService.saveCity(cityNumber);
    }

    @RolesAllowed({"1"})
    @DeleteMapping("{id}")
    public Msg deleteSaleById(@PathVariable("id") Integer id) {
        Msg msg = cityService.deleteCityById(id);
        return msg;
    }

}
