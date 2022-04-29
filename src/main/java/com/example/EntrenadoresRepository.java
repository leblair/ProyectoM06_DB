package com.example;

public interface EntrenadoresRepository extends Repository<Entrenadores> {
    void populate();
    Integer getLastId();
}
