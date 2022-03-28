package com.example;

import java.util.stream.Stream;

public interface Database {
    void insertarPelicula(String title);
    Stream<Movies> consultarPelicula();
    void insertarCancion(String title);
    Stream<Cancion> consultarCancion();

}
