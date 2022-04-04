package com.example;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class RepositoryMongo<T> implements Repository<T> {
    static MongoClient mongoClient;
    @Override
    public void init() {
        mongoClient = MongoClients.create("mongodb://localhost");
    }

    @Override
    public void insert(Object o) {
        MongoDatabase database = mongoClient.getDatabase("sampledb");
        MongoCollection<Document> collection = database.getCollection("movies");
        Document doc = new Document();
//        doc.append("title", title);
        collection.insertOne(doc);
    }

    @Override
    public List<T> getAll() {
        List<T> movies = new ArrayList<>();
        MongoDatabase database = mongoClient.getDatabase("sampledb");
        //MongoCollection<Document> collection = database.getCollection("movies");
        FindIterable<Document> iterable = database.getCollection("movies").find();
        iterable.forEach(document -> {
            T t = getNewInstance();
            System.out.println(document);
            //            t.getClass().getDeclaredField().set(t, resultSet.getObject(field.getName()));

            movies.add((T) document);
        });

        return  null;
    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void delete(int id) {

    }
}
