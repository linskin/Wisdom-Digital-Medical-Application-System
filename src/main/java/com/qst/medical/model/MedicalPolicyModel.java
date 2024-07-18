package com.qst.medical.model;

import com.qst.medical.domain.MedicalPolicy;

public class MedicalPolicyModel extends MedicalPolicy {

    private CityModel cityModel;

    public CityModel getCityModel() {
        return cityModel;
    }

    public void setCityModel(CityModel cityModel) {
        this.cityModel = cityModel;
    }
}
