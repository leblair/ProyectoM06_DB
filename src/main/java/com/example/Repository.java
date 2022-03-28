package com.example;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public interface Repository<T> {
    default String getTableName(){
        String className = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].getTypeName();

        return className;
    }
    void init();

    default Field[] getFields(){
       Field[] fields = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].getClass().getDeclaredFields();


        return fields;
    }
}
