package com.example;

import java.util.Scanner;

public class Demo {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quieres mysql?");
        Database db = null;
        String dbtype = scanner.nextLine();
        if ("si".equals(dbtype)) {
            db = new DatabaseMySql();
        } else {

            db = new DatabaseMongo();
        }
        System.out.println("Title:");
        String title = scanner.nextLine();


        db.insertarPelicula(title);
        db.consultarPelicula();
    }
}
