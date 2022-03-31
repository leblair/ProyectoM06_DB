package com.example;

import com.mysql.cj.xdevapi.Table;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Locale;

public interface Repository<T> {

    void init();
    void insert(T t);
    List<T> getAll();

    default T getNewInstance() {
        try {
            return (T) getType().getDeclaredConstructor().newInstance();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;
    }

    default Class<?> getType() {
        return ((Class<?>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    default String getTableName(){

        String[] tal = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].getTypeName().split("\\.");
        return tal[tal.length-1].toLowerCase();
    }

    default Field[] getFields() {
        return ((Class<?>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getDeclaredFields();
    }
}


// com.example.db.dsffsd.Movie