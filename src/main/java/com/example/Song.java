package com.example;


import org.bson.types.ObjectId;

import java.util.StringJoiner;
import java.util.stream.Stream;

public class Song {

    String name;
    String duration;
    String rating;
    Integer id;
    ObjectId _id;

    public Song(String name, String duration, String rating, ObjectId _id) {
        this.name = name;
        this.duration = duration;
        this.rating = rating;
        this._id = _id;
    }

    public Song(String name, String duration, String rating) {
        this.name = name;
        this.duration = duration;
        this.rating = rating;
    }

    public Song(String name, String duration, String rating, Integer id) {
        this.name = name;
        this.duration = duration;
        this.rating = rating;
        this.id = id;
    }

    public Song() {
    }


    static Stream<String> toMaster(Song p) {
        return Stream.of(new StringJoiner(", ")
                .add("Id=\33[34m" + p.id + "\33[0m")
                .add("Name='\33[34m" + p.name + "\33[0m'")
                .add("duration='\33[34m" + p.duration + "\33[0m'")
                .add("rating='\33[34m" + p.rating + "\33[0m'")
                .toString());
    }

    static Stream<String> toMasterMongo(Song p) {
        return Stream.of(new StringJoiner(", ")
                .add("Id=\33[34m" + p._id + "\33[0m")
                .add("Name='\33[34m" + p.name + "\33[0m'")
                .add("duration='\33[34m" + p.duration + "\33[0m'")
                .add("rating='\33[34m" + p.rating + "\33[0m'")
                .toString());
    }
}
