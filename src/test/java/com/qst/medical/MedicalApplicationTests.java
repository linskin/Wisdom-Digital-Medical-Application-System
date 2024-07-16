package com.qst.medical;

//import com.qst.medical.service.CompanyService;
//import com.qst.medical.service.DrugService;
import com.qst.medical.domain.DrugCompany;
import com.qst.medical.mapper.DrugCompanyMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class MedicalApplicationTests {
    @Autowired
    DrugCompanyMapper drugCompanyMapper;
    @Test
    public void testSelectList() {
        List<DrugCompany> list = drugCompanyMapper.selectList("");
//        for (DrugCompany company : list){
//            System.out.println(company);
//        }
    }


}
