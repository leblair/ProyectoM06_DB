package com.example;

import com.mongodb.client.*;
import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;

public class DatabaseMongo extends Database{


    @Override
    void insertarPelicula(String title) {
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
    void consultarPelicula() {
        String uri = "mongodb://localhost";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("sampledb");
            //ongoCollection<Document> collection = database.getCollection("movies");
            FindIterable<Document> iterable  = database.getCollection("movies").find();
            iterable.forEach(document -> System.out.println(document));

        }
        //QUERY
//
    }
}