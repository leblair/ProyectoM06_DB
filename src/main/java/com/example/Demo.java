package com.example;

import java.util.Locale;
import java.util.Scanner;

public class Demo {
    static Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
    static EntrenadoresRepository entrenadorRepository;

    public static void main(String[] args) {
        System.out.println("What database do you want to use: 1:MongoDB/ 2:MySQL");
        int opcion = scanner.nextInt();
        if (opcion == 1) {
            entrenadorRepository = new EntrenadoresRepositoryMongo();
        }else if(opcion == 2) {
            entrenadorRepository = new EntrenadoresRepositorySQL();
        }

        entrenadorRepository.init();
        startApp();
    }

    static void startApp() {
        while (true) {
            System.out.println("\33[1;30;45m--- MASTER SCREEN ---\33[0m\n");
            entrenadorRepository.getAll();
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
                Entrenadores trainer = new Entrenadores(name,age);
                entrenadorRepository.insert(trainer);
            } else {
                System.out.print("Trainer ID: ");
                int trainerId = scanner.nextInt();
                if (option.equals("c")) {
                } else if (option.equals("u")) {
                    System.out.print("New Trainer name : ");
                    String newName = scanner.next();
                    System.out.print("New Trainer age : ");
                    int newAge = scanner.nextInt();
                    entrenadorRepository.update(new Entrenadores(newName,newAge, trainerId));
                } else if (option.equals("d")) {
                    entrenadorRepository.delete(trainerId);
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
