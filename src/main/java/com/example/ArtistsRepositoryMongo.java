package com.example;

import com.mongodb.client.MongoDatabase;

public class ArtistsRepositoryMongo extends RepositoryMongo<Artists> implements ArtistsRepository {

    @Override
    public void populate() {

    }

    @Override
    public Integer getLastId() {
        MongoDatabase database = mongoClient.getDatabase("sampledb");
        database.getCollection("artists").find().limit(1);
        return null;
    }


}
