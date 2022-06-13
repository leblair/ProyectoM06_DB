package com.example;

import org.bson.types.ObjectId;

import java.util.StringJoiner;
import java.util.stream.Stream;

public class Artists {
    String name;
    int age;
    String discography;
    Integer id;
    ObjectId _id;

    public Artists() {
    }

    public Artists(String name, int age, ObjectId _id) {
        this.name = name;
        this.age = age;
        this._id = _id;
    }

    public Artists(String name, int age, Integer id) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public Artists(String title, int age, String discography
            , Integer id) {
        this.name = title;
        this.age = age;
        this.discography = discography;
        this.id = id;
    }

    public Artists(String title, int age) {
        this.age = age;
        this.name = title;
    }

    static Stream<String> toMaster(Artists p) {
        return Stream.of(new StringJoiner(", ")
                .add("Id=\33[34m" + p.id + "\33[0m")
                .add("Name='\33[34m" + p.name + "\33[0m'")
                .add("Age='\33[34m" + p.age + "\33[0m'")
                .add("discography='\33[34m" + p.discography + "\33[0m'")
                .toString());
    }

    static Stream<String> toMasterMongo(Artists p) {
        return Stream.of(new StringJoiner(", ")
                .add("Id=\33[34m" + p._id + "\33[0m")
                .add("Name='\33[34m" + p.name + "\33[0m'")
                .add("Age='\33[34m" + p.age + "\33[0m'")
                .add("discography='\33[34m" + p.discography + "\33[0m'")
                .toString());
    }

}
