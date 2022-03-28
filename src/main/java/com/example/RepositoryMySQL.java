package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public abstract class RepositoryMySQL<T> implements Repository<T> {
    static Connection conn;

    public void init(){
        try{
            conn = DriverManager.getConnection(System.getProperty("sqlurl"));
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void insert(T t){
        try{
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO " + getTableName() + " VALUES(" + "?".repeat(getFields().length -1) +"?" );
            for (int i = 1; i <getFields().length ; i++) {
                preparedStatement.setObject(i,t.getClass().getDeclaredField(getFields()[i-1].getName()).get(i - 1)).get(t);
            }
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<T> getAll(){
        List<T> list = new ArrayList<>();
        try{
        final ResultSet resultSet = conn.createStatement().executeQuery("SELECT * FROM " + getTableName());

        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}

