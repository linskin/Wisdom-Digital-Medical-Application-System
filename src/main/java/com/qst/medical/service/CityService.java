package com.qst.medical.service;

import com.github.pagehelper.PageInfo;
import com.qst.medical.model.CityModel;
import com.qst.medical.util.Msg;

public interface CityService {

    PageInfo<CityModel> getCityWithPage(Integer pn, Integer size, String name);

    Msg deleteCityById(Integer id);

    Msg saveCity(Integer cityNumber);

    int checkCityByName(Integer cityNumber);

    Msg getCityById(Integer id);
}
