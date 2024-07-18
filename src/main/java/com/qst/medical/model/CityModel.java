package com.qst.medical.model;

import com.qst.medical.domain.City;

public class CityModel extends City {
    private String province;//省份
    private String city;//市

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
