package com.example;

import com.mongodb.client.MongoDatabase;

public class EntrenadoresRepositoryMongo extends RepositoryMongo<Entrenadores> implements EntrenadoresRepository {

    @Override
    public void populate() {

    }

    @Override
    public Integer getLastId() {
        MongoDatabase database = mongoClient.getDatabase("sampledb");
        database.getCollection("entrenadores").find().limit(1);
        return null;
    }


}
