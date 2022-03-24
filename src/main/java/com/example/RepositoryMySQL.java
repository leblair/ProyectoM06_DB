package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/*

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
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO " + getTableName() + " VALUES(" + "?".repeat(getFields().length -1) "?" );
            for (int i = 1; i <getFields().length ; i++) {


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
*/
