package com.qst.medical.model;

public class TreatTypeModel {
    private Long id;
    public String name;

    @Override
    public String toString() {
        return "TreatTypeModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}