package org.globant.university.persistence;

import org.globant.university.data.*;

import java.util.List;

public class DataInitializer {
    public static University loadUniversity() {
        University university = new University("Globant University");

        loadFullTimeTeachers(university);
        loadPartTimeTeachers(university);
        loadStudents(university);
        loadSubjects(university);

        return university;
    }

    public static void loadFullTimeTeachers(University university){
        university.registerFullTimeTeacher("Eduardo Perea", 2000000, 5);
        university.registerFullTimeTeacher("Liliana Restrepo", 5000000, 8);
    }

    public static void loadPartTimeTeachers(University university){
        university.registerPartTimeTeacher("Maria Lopez", 1500000, 48);
        university.registerPartTimeTeacher("Pedro Lopera", 2000000, 40);
    }

    public static void loadStudents(University university){
        university.registerStudent("Joe Gonzalez", 20);
        university.registerStudent("Carlos Leal", 18);
        university.registerStudent("Emilio Navarro", 22);
        university.registerStudent("Carlos Ferro", 25);
        university.registerStudent("Andres Theran", 20);
        university.registerStudent("Felipe Rivas", 27);
    }

    public static void loadSubjects(University university){
        List<Teacher> teacherList = university.getTeacherList();

        Subject subject1 =  university.createSubject("Art", "R-001", teacherList.get(0));
        Subject subject2 = university.createSubject("Mathematics", "R-002", teacherList.get(1));
        Subject subject3 = university.createSubject("Literacy", "R-003", teacherList.get(2));
        Subject subject4 = university.createSubject("Chemistry", "R-004", teacherList.get(3));

        university.addStudentToSubject(subject1, university.getStudentByIndex(0));
        university.addStudentToSubject(subject1, university.getStudentByIndex(1));
        university.addStudentToSubject(subject2, university.getStudentByIndex(2));
        university.addStudentToSubject(subject3, university.getStudentByIndex(3));
        university.addStudentToSubject(subject3, university.getStudentByIndex(4));
        university.addStudentToSubject(subject4, university.getStudentByIndex(5));
    }
}
