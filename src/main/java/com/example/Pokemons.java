package com.example;


import java.util.StringJoiner;
import java.util.stream.Stream;

public class Pokemons {

    String name;
    String tipo_principal;
    String tipo_secundario;
    Integer id;

    public Pokemons(String name, String tipo_principal, String tipo_secundario) {
        this.name = name;
        this.tipo_principal = tipo_principal;
        this.tipo_secundario = tipo_secundario;
    }

    public Pokemons(String name, String tipo_principal, String tipo_secundario, Integer id) {
        this.name = name;
        this.tipo_principal = tipo_principal;
        this.tipo_secundario = tipo_secundario;
        this.id = id;
    }

    public Pokemons() {
    }


    static Stream<String> toMaster(Pokemons p) {
        return Stream.of(new StringJoiner(", ")
                .add("Id=\33[34m" + p.id + "\33[0m")
                .add("Name='\33[34m" + p.name + "\33[0m'")
                .add("firstType='\33[34m" + p.tipo_principal + "\33[0m'")
                .add("secondType='\33[34m" + p.tipo_secundario + "\33[0m'")
                .toString());
    }
}
