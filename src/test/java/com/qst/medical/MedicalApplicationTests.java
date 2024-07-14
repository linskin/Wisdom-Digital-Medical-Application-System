package com.qst.medical;

//import com.qst.medical.service.CompanyService;
//import com.qst.medical.service.DrugService;
import com.qst.medical.service.login.LoginorOutService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;


@SpringBootTest
class MedicalApplicationTests {
//
//    @Autowired
//    private LoginorOutService adminMapper;
//
//    @Autowired
//    private CompanyMapper companyMapper;
//
//    @Autowired
//    private CompanyService companyService;
//
//    @Autowired
//    private DrugMapper drugMapper;
//
//    @Autowired
//    private DrugService drugService;
//
//    @Autowired
//    private MedicalPolicyMapper medicalPolicyMapper;
//
//    @Autowired
//    private SaleMapper saleMapper;
//
//    @Test
//    void insertTest(){
//        SaleEntity sale=new SaleEntity();
//        sale.setSaleName("王五大药房");
//        sale.setSalePhone("12233334444");
//        sale.setUpdatetime(new Date());
//        sale.setUpdatetime(new Date());
//        System.out.println(saleMapper.saveSale(sale));
//    }

    @Test
    void contextLoads() {
        /*Long[] lll = {1L,2L,3L};
        drugMapper.insertSalePlace(12650427L,lll);*/
        /*DrugParam drugParam = new DrugParam();
        drugParam.setDrugName("lllld");
        drugParam.setDrugInfo("ksjdfl");
        drugParam.setDrugEffect("sdjfsa");
        drugParam.setSaleIds(new Long[]{1L,2L,3L});
        drugService.saveDrug(drugParam);
        System.out.println(drugParam.getDrugId()+""+drugParam.getTotal());*/

       /* MedicalPolicyParam medicalPolicyParam = new MedicalPolicyParam();
        medicalPolicyParam.setCityId(1L);
        //medicalPolicyParam.setPublishDate(new DateTime());
        medicalPolicyMapper.getAllPolicy(medicalPolicyParam).forEach((item) ->{
            System.out.println(item);
        });*/

        System.out.println(new BCryptPasswordEncoder().encode("admin"));
    }

}
