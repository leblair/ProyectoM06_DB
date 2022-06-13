package com.example;

public interface ArtistsRepository extends Repository<Artists> {
    void populate();
    Integer getLastId();
}
