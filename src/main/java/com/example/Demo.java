package com.example;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Demo {
    static Scanner scanner = new Scanner(System.in);
    static PeliculaRepositorySQL peliculaRepository = new PeliculaRepositorySQL();
    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Quieres mysql?");
//        Database db = null;
//        String dbtype = scanner.nextLine();
//        if ("si".equals(dbtype)) {
//            db = new DatabaseMySql();
//        } else {
//            db = new DatabaseMongo();
//        }
//
//        System.out.println("Title:");
//        String title = scanner.nextLine();
        peliculaRepository.init();
        startApp();

//        db.insertarPelicula(title);
//        db.consultarPelicula();
    }

    static void startApp() {
        while (true) {
            System.out.println("\33[1;30;45m--- MASTER SCREEN ---\33[0m\n");
//            peliculaRepository.poulate();

            peliculaRepository.getAll().stream().flatMap(Movies::toMaster).forEach(System.out::println);
//            repository.readAllPersons();
            System.out.print("\n\33[1;30;45m[PERSON] CREATE/READ/UPDATE/DELETE or QUIT:\33[0m ");
            String option = scanner.next().substring(0, 1).toLowerCase(Locale.ROOT);

            if (option.equals("q")) {
                break;
            } else if (option.equals("c")) {
                System.out.print("Movie Title: ");
                String title = scanner.next();
                peliculaRepository.insert(new Movies(title));
            } else {

                System.out.print("Movie ID: ");
                int movieid = scanner.nextInt();
                if (option.equals("c")) {

//                if (option.equals("u")) {
//                    System.out.println("New movie title : ");
//                    String newName = scanner.next();
//                    repository.updatePerson(new Person(personid, newName));
//                } else if (option.equals("d")) {
//                    repository.deletePerson(personid);
//                } else if (option.equals("r")) {
//                    while (true) {
//                        System.out.println("\33[1;30;104m--- DETAIL SCREEN ---\33[0m\n");
////                        repository.readPerson(personid).flatMap(Person::toDetail).forEach(System.out::println);
//                        System.out.print("\n\33[1;30;104m[THING] CREATE/UPDATE/DELETE or BACK:\33[0m ");
//                        option = scanner.next().substring(0, 1).toLowerCase(Locale.ROOT);
//                        if (option.equals("b")) {
//                            break;
//                        } else if (option.equals("c")) {
//                            System.out.println("Thing title: ");
//                            String title = scanner.next();
//                            repository.createThing(new Thing(title, personid));
//                        } else {
//                            System.out.print("Thing ID: ");
//                            int thingid = scanner.nextInt();
//
//                            if (option.equals("u")) {
//                                System.out.println("Thing new title: ");
//                                String newTitle = scanner.next();
//                                repository.updateThing(new Thing(thingid, newTitle));
//                            } else if (option.equals("d")) {
//                                repository.deleteThing(thingid);
//                            }
//                        }
//                    }
//                }
               }
            }
        }
    }
}
