package com.qst.medical.mapper;

import java.io.Serializable;
import java.util.List;


//该泛形接口用于减少编码量
public interface BaseMapper <T>{

    int insert(T t);

    int update(T t);

    int delete(T t);

    T selectByPrimaryKey(Serializable id);
}
