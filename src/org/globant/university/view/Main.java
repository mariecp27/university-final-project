package org.globant.university.view;

import org.globant.university.data.Student;
import org.globant.university.data.Subject;
import org.globant.university.data.Teacher;
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
            System.out.println("5. List classes per student");
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
                    registerNewStudent(university);
                    break;
                case "4":
                    createNewSubject(university);
                    break;
                case "5":
                    getSubjectsPerStudent(university);
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
        int overSubjectsAmount = university.getSubjectsAmount() + 1;
        int subjectsMenuOption;
        do {
            System.out.println("Which class information would you like to check today?");
            printSubjectList(university);
            System.out.println(overSubjectsAmount + ". Go back");
            try {
                subjectsMenuOption = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                subjectsMenuOption = 0;
            }
            scanner = new Scanner(System.in);
            if (subjectsMenuOption < overSubjectsAmount && subjectsMenuOption > 0) {
                getSubjectsInfo(university, (subjectsMenuOption - 1));
            } else if(subjectsMenuOption > overSubjectsAmount || subjectsMenuOption == 0) {
                System.out.println("Please enter a valid option: 1 - " + overSubjectsAmount);
            }
            System.out.println();
        } while (subjectsMenuOption != overSubjectsAmount);
    }

    public static void printSubjectList(University university) {
        if (university.getSubjectsAmount() == 0) {
            System.out.println("Oh, at the moment, there are not registered classes in our system");
        } else {
            for (int i = 0; i < university.getSubjectsAmount(); i++) {
                System.out.println((i + 1) + ". " + university.getSubjectName(i));
            }
        }
    }

    public static void getSubjectsInfo(University university, int index){
        System.out.println(university.getSubjectsInfo(index));
    }

    public static void registerNewStudent(University university){
        Scanner scanner = new Scanner(System.in);
        String studentName;
        int studentAge;
        boolean continueProcedure = true;

        do {
            System.out.println("Please enter the student full name:");
            studentName = scanner.nextLine();
            scanner = new Scanner(System.in);
            if (!checkIfSpecialCharacter(studentName)) {
                continueProcedure = false;
            } else {
                System.out.println("The student name should not contain any number nor special characters");
                System.out.println();
            }
        } while (continueProcedure);

        continueProcedure = true;
        do {
            System.out.println("Please enter the student age:");
            try {
                studentAge = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                studentAge = 0;
            }
            scanner = new Scanner(System.in);
            if (studentAge <= 0){
                System.out.println("Please enter a valid age");
                System.out.println();
            } else {
                Student student = university.registerStudent(studentName, studentAge);
                getRegisterStudentInSubjectMenu(university, student);
                continueProcedure = false;
            }
        } while (continueProcedure);
        System.out.println();
    }

    public static void getRegisterStudentInSubjectMenu(University university, Student student){
        Scanner scanner = new Scanner(System.in);
        int subjectsMenuOption;
        int subjectsAmount = university.getSubjectsAmount();
        boolean continueProcedure = true;

        do {
            System.out.println("Which class do you want to register the student at?");
            printSubjectList(university);
            try {
                subjectsMenuOption = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                subjectsMenuOption = 0;
            }
            scanner = new Scanner(System.in);
            if (subjectsMenuOption <= subjectsAmount && subjectsMenuOption > 0) {
                registerStudentInSubject(university, student, (subjectsMenuOption - 1));
                String subjectName = university.getSubjectName(subjectsMenuOption - 1);
                System.out.println("The student has been successfully registered in " + subjectName);
                continueProcedure = false;
            } else if(subjectsMenuOption > subjectsAmount || subjectsMenuOption == 0) {
                System.out.println("Please enter a valid option: 1 - " + subjectsAmount);
                System.out.println();
            }
        } while (continueProcedure);
    }

    public static void registerStudentInSubject(University university, Student student, int index){
        Subject subject = university.getSubjectByIndex(index);
        university.addStudentToSubject(subject, student);
    }

    public static void createNewSubject(University university){
        Scanner scanner = new Scanner(System.in);
        String subjectName;
        String classroom;

        System.out.println("Please enter the class name:");
        subjectName = scanner.nextLine();
        scanner = new Scanner(System.in);

        if (!university.checkSubjectName(subjectName)) {
            System.out.println("Please enter the classroom:");
            classroom = scanner.nextLine();
            scanner = new Scanner(System.in);

            Subject subject = university.createTemporalSubject(subjectName, classroom);
            Teacher selectedTeacher = addTeacherToClass(university);
            university.assignTeacherToSubject(subject, selectedTeacher);
            addStudentsToClass(university, subject);
            System.out.println("The class " + subjectName + " has been successfully created");
            System.out.println();
        } else {
            System.out.println("This class is already in the system, please check the classes information for further details");
            System.out.println();
        }
    }

    public static Teacher addTeacherToClass(University university){
        Scanner scanner = new Scanner(System.in);
        int selectedTeacher;
        int teachersAmount = university.getTeachersAmount();
        boolean continueProcedure = true;

        do {
            System.out.println("Which professor will be in charge of the class?");
            printTeachersName(university);
            try {
                selectedTeacher = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                selectedTeacher = 0;
            }
            scanner = new Scanner(System.in);
            if (selectedTeacher <= teachersAmount && selectedTeacher > 0) {
                continueProcedure = false;
            } else if(selectedTeacher > teachersAmount || selectedTeacher == 0) {
                System.out.println("Please enter a valid option: 1 - " + teachersAmount);
                System.out.println();
            }
        } while (continueProcedure);

        return university.getTeacherByIndex(selectedTeacher - 1);
    }

    public static void printTeachersName(University university){
        if (university.getTeachersAmount() == 0) {
            System.out.println("Oh, at the moment, there are not registered professors in our system");
        } else {
            for (int i = 0; i < university.getTeachersAmount(); i++) {
                System.out.println((i + 1) + "." + university.getTeacherName(i));
            }
        }
    }

    public static void addStudentsToClass(University university, Subject subject){
        Scanner scanner = new Scanner(System.in);
        int selectedStudent;
        int overStudentsAmount = university.getStudentsAmount() + 1;

        do {
            System.out.println("Which student do you want to add to the class?");
            printStudentsName(university);
            System.out.println(overStudentsAmount + ". I do not need to add more students");
            try {
                selectedStudent = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                selectedStudent = 0;
            }
            scanner = new Scanner(System.in);
            if (selectedStudent < overStudentsAmount && selectedStudent > 0) {
                Student student = university.getStudentByIndex(selectedStudent - 1);
                university.addStudentToSubject(subject, student);
            } else if(selectedStudent > overStudentsAmount || selectedStudent == 0) {
                System.out.println("Please enter a valid option: 1 - " + overStudentsAmount);
                System.out.println();
            }
        } while (selectedStudent != overStudentsAmount);
    }

    public static void printStudentsName(University university){
        if (university.getStudentsAmount() == 0) {
            System.out.println("Oh, at the moment, there are not registered students in our system");
        } else {
            for (int i = 0; i < university.getStudentsAmount(); i++) {
                System.out.println((i + 1) + ". " + university.getStudentName(i));
            }
        }
    }

    public static void getSubjectsPerStudent(University university){
        Scanner scanner = new Scanner(System.in);
        int selectedStudent;
        int overStudentsAmount = university.getStudentsAmount() + 1;

        do {
            System.out.println("Which student classes do you want to check?");
            printStudentsName(university);
            System.out.println(overStudentsAmount + ". Go back");
            try {
                selectedStudent = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                selectedStudent = 0;
            }
            scanner = new Scanner(System.in);
            if (selectedStudent < overStudentsAmount && selectedStudent > 0) {
                System.out.println("The student " + university.getStudentName(selectedStudent - 1) + " is registered in:");
                for (int i = 0; i < university.subjectsPerStudentAmount(selectedStudent - 1); i++) {
                    System.out.println((i + 1) + ". "  + university.subjectsNamePerStudent(selectedStudent - 1, i));
                }
                System.out.println();
            } else if(selectedStudent > overStudentsAmount || selectedStudent == 0) {
                System.out.println("Please enter a valid option: 1 - " + overStudentsAmount);
                System.out.println();
            }
        } while (selectedStudent != overStudentsAmount);
    }

    public static boolean checkIfSpecialCharacter(String word){
        boolean isSpecialCharacter = false;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!Character.isLetter(chars[i]) && !Character.isWhitespace(chars[i])) {
                isSpecialCharacter = true;
            }
        }
        return isSpecialCharacter;
    }
}
