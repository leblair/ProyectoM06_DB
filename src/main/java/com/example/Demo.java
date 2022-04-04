package com.example;

import java.util.Locale;
import java.util.Scanner;

public class Demo {
    static Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
    static PeliculaRepository peliculaRepository ;

    public static void main(String[] args) {
        System.out.println("What database do you want to use: 1:MongoDB/ 2:MySQL");
        int opcion = scanner.nextInt();
        if (opcion == 1) {
            peliculaRepository = new PeliculaRepositoryMongo();
        }else if(opcion == 2) {
            peliculaRepository = new PeliculaRepositorySQL();
        }

        peliculaRepository.init();
        startApp();
    }

    static void startApp() {
        while (true) {
            System.out.println("\33[1;30;45m--- MASTER SCREEN ---\33[0m\n");
            peliculaRepository.getAll();
            peliculaRepository.getAll().stream().flatMap(Movies::toMaster).forEach(System.out::println);
            System.out.print("\n\33[1;30;45m[PERSON] CREATE/READ/UPDATE/DELETE or QUIT:\33[0m ");
            String option = scanner.next().substring(0, 1).toLowerCase(Locale.ROOT);

            if (option.equals("q")) {
                break;
            } else if (option.equals("c")) {
                System.out.print("Movie Title: ");
                String title = scanner.next();
                Movies movie = new Movies(title);
                peliculaRepository.insert(movie);
            } else {
                System.out.print("Movie ID: ");
                int movieid = scanner.nextInt();
                if (option.equals("c")) {
                } else if (option.equals("u")) {
                    System.out.print("New movie title : ");
                    String newName = scanner.next();
                    peliculaRepository.update(new Movies(newName, movieid));
                } else if (option.equals("d")) {
                    peliculaRepository.delete(movieid);
                }
//                else if (option.equals("r")) {
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
            }
        }
    }
}

//    }
//}
