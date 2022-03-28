package com.example;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Locale;

public interface Repository<T> {
    default String getTableName(){

        return ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].getTypeName().substring(12).toLowerCase();
    }
    void init();

    default Field[] getFields(){

        return ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].getClass().getDeclaredFields();
    }
    default T getNewInstance(){
        return (T)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].getClass();
    }
}
