package com.example;

import java.sql.*;
import java.util.stream.Stream;

public class DatabaseMySql implements Database {

    @Override
    public void insertarPelicula(String title) {
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
    public Stream<Movies> consultarPelicula() {
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
        return null;
    }

    @Override
    public void insertarCancion(String title) {

    }

    @Override
    public Stream<Cancion> consultarCancion() {
        return null;
    }
}