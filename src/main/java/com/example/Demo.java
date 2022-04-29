package com.example;

import java.util.Locale;
import java.util.Scanner;

public class Demo {
    static Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
    static EntrenadoresRepository entrenadorRepository;
    static PokemonsRepository pokemonsRepository;
    static int opcion;
    static int opcionTable;

    public static void main(String[] args) {
        System.out.println("What database do you want to use: 1:MongoDB/ 2:MySQL");
        opcion = scanner.nextInt();
        if (opcion == 1) {
            entrenadorRepository = new EntrenadoresRepositoryMongo();
            pokemonsRepository = new PokemonsRepositoryMongo();
        } else if (opcion == 2) {
            entrenadorRepository = new EntrenadoresRepositorySQL();
            pokemonsRepository = new PokemonRepositorySQL();
        }
        System.out.println("What Table do you want to use: 1:Entrenadores/ 2:Pokemon");
        opcionTable = scanner.nextInt();

        if (opcionTable == 1) {
            entrenadorRepository.init();
            startAppEntrenador();
        } else {
            pokemonsRepository.init();
            startAppPokemon();
        }
    }

    static void startAppEntrenador() {
        while (true) {
            Entrenadores trainer;
            System.out.println("\33[1;30;45m--- MASTER SCREEN ---\33[0m\n");

            entrenadorRepository.getAll().stream().flatMap(Entrenadores::toMaster).forEach(System.out::println);

            System.out.print("\n\33[1;30;45m[PERSON] CREATE/READ/UPDATE/DELETE or QUIT:\33[0m ");
            String option = scanner.next().substring(0, 1).toLowerCase(Locale.ROOT);

            if (option.equals("q")) {
                break;
            } else if (option.equals("c")) {
                System.out.print("Trainer Name:");
                String name = scanner.next();
                System.out.print("Trainer Age:");
                int age = scanner.nextInt();

                trainer = new Entrenadores(name, age);


                try {
                    entrenadorRepository.insert(trainer);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.print("Trainer Name: ");
                String trainerName = "";

                trainerName = scanner.next();

                if (option.equals("c")) {
                } else if (option.equals("u")) {
                    System.out.print("New Trainer name : ");
                    String newName = scanner.next();
                    System.out.print("New Trainer age : ");
                    int newAge = scanner.nextInt();
                    if (opcion == 1) {
                        entrenadorRepository.update(new Entrenadores(newName, newAge), trainerName);
                    } else {
                        entrenadorRepository.update(new Entrenadores(newName, newAge), trainerName);
                    }

                } else if (option.equals("d")) {
                    entrenadorRepository.delete(trainerName);
                }
            }
        }
    }

    static void startAppPokemon() {
        while (true) {
            Pokemons pokemon;
            System.out.println("\33[1;30;45m--- MASTER SCREEN ---\33[0m\n");

            pokemonsRepository.getAll().stream().flatMap(Pokemons::toMaster).forEach(System.out::println);

            System.out.print("\n\33[1;30;45m[PERSON] CREATE/READ/UPDATE/DELETE or QUIT:\33[0m ");
            String option = scanner.next().substring(0, 1).toLowerCase(Locale.ROOT);

            if (option.equals("q")) {
                break;
            } else if (option.equals("c")) {
                System.out.print("Pokemon Name:");
                String name = scanner.next();
                System.out.print("Pokemon Type1:");
                String tipo1 = scanner.next();
                System.out.print("Pokemon Type2:");
                String tipo2 = scanner.next();
                pokemon = new Pokemons(name, tipo1, tipo2);


                try {
                    pokemonsRepository.insert(pokemon);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.print("Pokemon Name: ");
                String pokemonName = "";

                pokemonName = scanner.next();

                if (option.equals("c")) {
                } else if (option.equals("u")) {
                    System.out.print("New Pokemon name : ");
                    String newName = scanner.next();
                    System.out.print("New Pokemon type1 : ");
                    String newType1 = scanner.next();
                    System.out.print("New Pokemon type2 : ");
                    String newType2 = scanner.next();
                    if (opcion == 1) {
                        pokemonsRepository.update(new Pokemons(newName, newType1, newType2), pokemonName);
                    } else {
                        pokemonsRepository.update(new Pokemons(newName, newType1, newType2), pokemonName);
                    }

                } else if (option.equals("d")) {
                    entrenadorRepository.delete(pokemonName);
                }
            }
        }
    }
}

