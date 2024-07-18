package com.qst.medical.mapper;

import java.io.Serializable;
import java.util.List;


//该泛形接口用于减少编码量
public interface BaseMapper <T>{

    Integer insert(T t);

    Integer update(T t);

    Integer delete(T t);

    T selectByPrimaryKey(Serializable id);
}
