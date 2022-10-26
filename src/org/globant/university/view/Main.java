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

            switch (mainManuOption) {
                case "1":
                    printTeacherList(university);
                    break;
                case "2":
                    getSubjectsMenu(university);
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

    public static void printTeacherList(University university) {
        if (university.getTeachersAmount() == 0) {
            System.out.println("Oh, at the moment, there are not registered professors in our system");
        } else {
            for (int i = 0; i < university.getTeachersAmount(); i++) {
                System.out.println((i + 1) + "." + university.getTeachersInfo(i));
                System.out.println();
            }
        }
    }

    public static void getSubjectsMenu(University university) {
        Scanner scanner = new Scanner(System.in);
        int subjectsAmount = university.getSubjectsAmount() + 1;
        int subjectsMenuOption = 0;
        do {
            System.out.println("Which class information would you like to check today?");
            printSubjectList(university);
            System.out.println(subjectsAmount + ".Go back");
            try {
                subjectsMenuOption = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Please enter a valid option: 1 - " + subjectsAmount);
                subjectsMenuOption = 0;
            }
            scanner = new Scanner(System.in);
            if (subjectsMenuOption < subjectsAmount && subjectsMenuOption > 0) {
                getSubjectsInfo(university, (subjectsMenuOption - 1));
            } else if(subjectsMenuOption > subjectsAmount) {
                System.out.println("Please enter a valid option: 1 - " + subjectsAmount);
            }
            System.out.println();
        } while (subjectsMenuOption != subjectsAmount);
    }

    public static void printSubjectList(University university) {
        if (university.getSubjectsAmount() == 0) {
            System.out.println("Oh, at the moment, there are not registered classes in our system");
        } else {
            for (int i = 0; i < university.getSubjectsAmount(); i++) {
                System.out.println((i + 1) + "." + university.getSubjectName(i));
            }
        }
    }

    public static void getSubjectsInfo(University university, int index){
        System.out.println(university.getSubjectsInfo(index));
    }
}
