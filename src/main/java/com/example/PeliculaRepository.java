package com.example;

public interface PeliculaRepository extends Repository<Movies> {
    void poulate();
}
