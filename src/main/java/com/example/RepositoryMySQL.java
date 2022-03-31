package com.example;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public abstract class RepositoryMySQL<T> implements Repository<T> {
    static Connection conn;

    @Override
    public void init() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/mydatabase?user=myuser&password=mypass");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(T t) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO " + getTableName() + " VALUES(" + "?".repeat(getFields().length - 1) + "?");
            for (int i = 1; i < getFields().length; i++) {
                preparedStatement.setObject(i, t.getClass().getDeclaredField(getFields()[i - 1].getName()).get(t));
            }
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public List<T> getAll() {
        List<T> list = new ArrayList<>();
        try {
            final ResultSet resultSet = conn.createStatement().executeQuery("SELECT * FROM " + getTableName());

            while (resultSet.next()) {
                T t = getNewInstance();
                for (Field field : getFields()) {

                    t.getClass().getDeclaredField(field.getName()).set(t, resultSet.getObject(field.getName()));
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    void update(T t) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE " + getTableName() + " SET title = " + "?" + "WHERE id =" + "?");
            System.out.println(t.getClass().getDeclaredField("title").get(t));
            preparedStatement.setObject(1, t.getClass().getDeclaredField("title").get(t));
            preparedStatement.setObject(2, t.getClass().getDeclaredField("id").get(t));
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

