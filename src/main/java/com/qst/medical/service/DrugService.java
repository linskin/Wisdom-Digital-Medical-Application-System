package com.qst.medical.service;

import com.github.pagehelper.PageInfo;
import com.qst.medical.model.DrugModel;
import com.qst.medical.param.DrugParam;
import com.qst.medical.util.Msg;

public interface DrugService {

    PageInfo<DrugModel> getDrugWithPage(int pn, int size, String name);

    Msg saveDrug(DrugParam drugParam);

    Msg updateDrug(Long id, DrugParam drugParam);

    Msg deleteDrug(Long drugId);
}
