package com.qst.medical.mapper;

import com.qst.medical.domain.City;
import com.qst.medical.entity.CityEntity;
import com.qst.medical.model.CityModel;

import java.util.List;

public interface CityMapper{
    List<CityModel> getAllCity(String name);

    City getCityById(Integer id);

    int saveCity(CityEntity city);

    int deleteCityById(Integer id);

    int checkCityByName(Integer number);
}
