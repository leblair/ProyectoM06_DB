package com.example;

import java.sql.*;

public class DatabaseMySql extends Database{

    @Override
    void insertarPelicula(String title) {
        String uri = "jdbc:mysql://localhost/mydatabase?user=myuser&password=mypass";
        try (Connection conn = DriverManager.getConnection(uri)) {
            //INSERT
            PreparedStatement statement = conn.prepareStatement("INSERT INTO movies(title) VALUES(?)");
            statement.setString(1, title);
            statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    void consultarPelicula() {
        String uri = "jdbc:mysql://localhost/mydatabase?user=myuser&password=mypass";

        try (Connection conn = DriverManager.getConnection(uri)) {
            //QUERY
            ResultSet resultSet = conn.createStatement().executeQuery("SELECT * FROM movies");
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString(title));
//            }

            while (resultSet.next()) {
                System.out.println(resultSet.getString("title"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}