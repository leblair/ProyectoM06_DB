package com.example;

import java.util.StringJoiner;
import java.util.stream.Stream;

public class Entrenadores {
    String name;
    int age;
    String med1;
    String med2;
    String med3;
    String med4;
    String med5;
    String med6;
    String med7;
    String med8;
    Integer id;

    public Entrenadores() {

    }

    public Entrenadores(String name) {
        this.name = name;
    }

    public Entrenadores(String name, int age, Integer id) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public Entrenadores(String title, int age, String med1, String med2,
                        String med3, String med4,
                        String med5, String med6, String med7, String med8, Integer id) {
        this.name = title;
        this.age = age;
        this.med1 = med1;
        this.med2 = med2;
        this.med3 = med3;
        this.med4 = med4;
        this.med5 = med5;
        this.med6 = med6;
        this.med7 = med7;
        this.med8 = med8;
        this.id = id;
    }

    public Entrenadores(String title, int age) {
        this.age=age;
        this.name =title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    static Stream<String> toMaster(Entrenadores p) {
        return Stream.of(new StringJoiner(", ")
                .add("Id=\33[34m" + p.id + "\33[0m")
                .add("Name='\33[34m" + p.name + "\33[0m'")
                .add("Age='\33[34m" + p.age + "\33[0m'")
                .add("Med1='\33[34m" + p.med1 + "\33[0m'")
                .add("Med2='\33[34m" + p.med2 + "\33[0m'")
                .add("Med3='\33[34m" + p.med3 + "\33[0m'")
                .add("Med4='\33[34m" + p.med4 + "\33[0m'")
                .add("Med5='\33[34m" + p.med5 + "\33[0m'")
                .add("Med6='\33[34m" + p.med6 + "\33[0m'")
                .add("Med7='\33[34m" + p.med7 + "\33[0m'")
                .add("Med8='\33[34m" + p.med8 + "\33[0m'")
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
