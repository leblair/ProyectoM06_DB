package com.example;

import java.util.StringJoiner;
import java.util.stream.Stream;

public class Movies {
    String name;
    Integer id;

    public Movies(String name) {
        this.name = name;
    }

    public Movies(String name, Integer id) {
        this.name = name;
        this.id = id;
    }
    static Stream<String> toMaster(Movies p) {
        return Stream.of(new StringJoiner(", ")
                .add("MovieId=\33[34m" + p.id + "\33[0m")
                .add("Title='\33[34m" + p.name + "\33[0m'")
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
