package com.example;

import java.util.StringJoiner;
import java.util.stream.Stream;

public class Movies {
    String title;
    Integer id;

    public Movies(){

    }
    public Movies(String name) {
        this.title = name;
    }

    public Movies(String name, Integer id) {
        this.title = name;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    static Stream<String> toMaster(Movies p) {
        return Stream.of(new StringJoiner(", ")
                .add("MovieId=\33[34m" + p.id + "\33[0m")
                .add("Title='\33[34m" + p.title + "\33[0m'")
                .toString());
    }

//    static Stream<String> toDetail(Pelicula p) {
//        return Stream.of(new StringJoiner(", ", Pelicula.class.getSimpleName() + ": ", "")
//                        .add("personid=\33[34m" + p.id + "\33[0m")
//                        .add("name='\33[34m" + p.name + "\33[0m'")
//                        .toString(),
//                "\t" + p.things.flatMap(Thing::toDetail).collect(Collectors.joining("\n\t")));
//    }
}
