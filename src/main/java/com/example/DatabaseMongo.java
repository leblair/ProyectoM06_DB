package com.example;

import com.mongodb.client.*;
import org.bson.Document;
import java.util.stream.Stream;

public class DatabaseMongo implements Database {


    @Override
    public void insertarPelicula(String title) {
        String uri = "mongodb://localhost";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("sampledb");
            MongoCollection<Document> collection = database.getCollection("movies");

            // INSERT
            Document doc = new Document();
            doc.append("title", title);
            collection.insertOne(doc);


        }
    }

    @Override
    public Stream<Pelicula> consultarPelicula() {
        String uri = "mongodb://localhost";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("sampledb");
            //MongoCollection<Document> collection = database.getCollection("movies");
            FindIterable<Document> iterable = database.getCollection("movies").find();
            iterable.forEach(document -> System.out.println(document));

        }
        //QUERY
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