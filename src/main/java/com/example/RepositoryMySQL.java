package com.example;

import org.bson.types.ObjectId;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public abstract class RepositoryMySQL<T> implements Repository<T> {
    static Connection conn;

    @Override
    public void init() {
        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost/mydatabase2?user=myuser&password=mypass");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(T t) {
        try {
            String insert = "INSERT INTO " + getTableName() +
                    " (";
            for (int i = 0; i < getFields().length - 2; i++) {
                if (i == getFields().length - 3) {
                    insert += getFields()[i].getName();
                } else {
                    insert += getFields()[i].getName() + ",";
                }

            }
            insert += ") VALUES(" + " ?, ".repeat(getFields().length - 3) + "?" + ")";
            PreparedStatement preparedStatement = conn.prepareStatement(insert);

            for (int i = 0; i < getFields().length - 2; i++) {
                preparedStatement.setObject(i + 1, t.getClass().getDeclaredField(getFields()[i]
                        .getName()).get(t));
            }

            preparedStatement.executeUpdate();

        } catch (SQLException | NoSuchFieldException | IllegalAccessException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<T> getAll() {
        List<T> list = new ArrayList<>();
        try {
            final ResultSet resultSet = conn.createStatement().executeQuery("SELECT * FROM " + getTableName());

            while (resultSet.next()) {
                T t = getNewInstance();
                for (Field field : getFields()) {
                    if (field.getType() != ObjectId.class) {
                        t.getClass().getDeclaredField(field.getName()).set(t, resultSet.getObject(field.getName()));
                    }
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void update(T t, String name) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE " + getTableName() + " SET name = " + "?" + "WHERE name =" + "?");
            preparedStatement.setObject(1, t.getClass().getDeclaredField("name").get(t));
            preparedStatement.setObject(2, name);
            preparedStatement.executeUpdate();

        } catch (SQLException | NoSuchFieldException | IllegalAccessException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(String name) {
        try {
            System.out.println("DELETE FROM " + getTableName() + " WHERE " + getFields()[0].getName() + " = " + name);
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM " + getTableName() + " WHERE " + getFields()[0].getName() + " = " + "\'" + name + "\'");
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

