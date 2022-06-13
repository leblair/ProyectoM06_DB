package com.example;

import org.bson.types.ObjectId;

import java.util.Locale;
import java.util.Scanner;


public class Demo {
    static Scanner sc = new Scanner(System.in).useDelimiter("\\n");
    static ArtistsRepository artistRepository;
    static SongsRepository songsRepository;
    static int opcion;
    static int opcionTable;


    public static void main(String[] args) {
        System.out.println("What database do you want to use: 1:MongoDB/ 2:MySQL");
        opcion = sc.nextInt();
        if (opcion == 1) {
            artistRepository = new ArtistsRepositoryMongo();
            songsRepository = new SongsRepositoryMongo();
        } else if (opcion == 2) {
            artistRepository = new ArtistsRepositorySQL();
            songsRepository = new SongsRepositorySQL();
        }
        System.out.println("What Table do you want to use: 1:Artists/ 2:Songs");
        opcionTable = sc.nextInt();

        if (opcionTable == 1) {
            artistRepository.init();
            startAppartist();
        } else {
            songsRepository.init();
            startAppSongs();
        }
    }

    static void startAppartist() {
        while (true) {
            Artists artist;
            System.out.println("\33[1;30;45m--- MASTER SCREEN ---\33[0m\n");
            if (opcion == 1) {
                artistRepository.getAll().stream().flatMap(Artists::toMasterMongo).forEach(System.out::println);

            } else {
                artistRepository.getAll().stream().flatMap(Artists::toMaster).forEach(System.out::println);
            }

            System.out.print("\n\33[1;30;45m[PERSON] CREATE/READ/UPDATE/DELETE or QUIT:\33[0m ");
            String option = sc.next().substring(0, 1).toLowerCase(Locale.ROOT);

            if (option.equals("q")) {
                break;
            } else if (option.equals("c")) {
                System.out.print("artist Name:");
                String name = sc.next();
                System.out.print("artist Age:");
                int age = sc.nextInt();
                if (opcion == 1) {
                    artist = new Artists(name, age, new ObjectId());
                } else {
                    artist = new Artists(name, age);
                }
                try {
                    artistRepository.insert(artist);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.print("artist Name: ");
                String artistName = "";

                artistName = sc.next();

                if (option.equals("c")) {
                } else if (option.equals("u")) {
                    System.out.print("New artist name : ");
                    String newName = sc.next();
                    System.out.print("New artist age : ");
                    int newAge = sc.nextInt();
                    if (opcion == 1) {
                        artistRepository.update(new Artists(newName, newAge), artistName);
                    } else {
                        artistRepository.update(new Artists(newName, newAge), artistName);
                    }

                } else if (option.equals("d")) {
                    artistRepository.delete(artistName);
                }
            }
        }
    }

    static void startAppSongs() {
        while (true) {
            Song song;
            System.out.println("\33[1;30;45m--- MASTER SCREEN ---\33[0m\n");
            if (opcion == 1) {
                songsRepository.getAll().stream().flatMap(Song::toMasterMongo).forEach(System.out::println);

            } else {
                songsRepository.getAll().stream().flatMap(Song::toMaster).forEach(System.out::println);

            }

            System.out.print("\n\33[1;30;45m[PERSON] CREATE/READ/UPDATE/DELETE or QUIT:\33[0m ");
            String option = sc.next().substring(0, 1).toLowerCase(Locale.ROOT);

            if (option.equals("q")) {
                break;
            } else if (option.equals("c")) {
                System.out.print("Song Name:");
                String name = sc.next();
                System.out.print("Song duration:");
                String tipo1 = sc.next();
                System.out.print("Song rating:");
                String tipo2 = sc.next();
                if (opcion == 1) {
                    song = new Song(name, tipo1, tipo2, new ObjectId());
                } else {
                    song = new Song(name, tipo1, tipo2);
                }


                try {
                    songsRepository.insert(song);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.print("song Name: ");
                String songName = "";

                songName = sc.next();

                if (option.equals("c")) {
                } else if (option.equals("u")) {
                    System.out.print("New song name : ");
                    String newName = sc.next();
                    System.out.print("New song duration : ");
                    String duration = sc.next();
                    System.out.print("New song rating : ");
                    String rating = sc.next();
                    if (opcion == 1) {
                        songsRepository.update(new Song(newName, duration, rating), songName);
                    } else {
                        songsRepository.update(new Song(newName, duration, rating), songName);
                    }

                } else if (option.equals("d")) {
                    songsRepository.delete(songName);
                }
            }
        }
    }
}

