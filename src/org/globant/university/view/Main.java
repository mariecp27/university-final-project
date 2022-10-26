package org.globant.university.view;

import org.globant.university.data.University;
import org.globant.university.persistence.DataInitializer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        University university = DataInitializer.loadUniversity();

        Scanner scanner = new Scanner(System.in);

        String mainManuOption;

        System.out.println("Welcome to " + university.getUniversityName());
        System.out.println("How can we help you today?");

        do {
            System.out.println("Menu:");
            System.out.println("1. Professors list");
            System.out.println("2. Classes lists");
            System.out.println("3. Register a new student");
            System.out.println("4. Create a new class");
            System.out.println("5. Are you one of our students? List your classes");
            System.out.println("6. Exit");

            mainManuOption = scanner.nextLine();
            scanner = new Scanner(System.in);

            switch (mainManuOption){
                case "1":
                    printTeacherList(university);
                    System.out.println();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    System.out.println("Have a nice day!");
                    break;
                default:
                    System.out.println("Please enter a valid option: 1 - 6");
                    System.out.println();
                    break;
            }
        } while (!mainManuOption.equals("6"));
    }

    public static void printTeacherList(University university){
        if (university.getTeachersAmount() == 0){
            System.out.println("Oh, there are not registered professors");
        } else {
            for (int i = 0; i < university.getTeachersAmount() ; i++) {
                System.out.println(university.getTeachersInfo(i));
                System.out.println();
            }
        }
    }
}
