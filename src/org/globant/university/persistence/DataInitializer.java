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
        FullTimeTeacher teacher1 = university.registerFullTimeTeacher("Eduardo Perea", 2000000, 5);
        FullTimeTeacher teacher2 = university.registerFullTimeTeacher("Liliana Restrepo", 5000000, 8);

        university.addTeacher(teacher1);
        university.addTeacher(teacher2);
    }

    public static void loadPartTimeTeachers(University university){
        PartTimeTeacher teacher3 = university.registerPartTimeTeacher("Maria Lopez", 1500000, 48);
        PartTimeTeacher teacher4 = university.registerPartTimeTeacher("Pedro Lopera", 2000000, 40);

        university.addTeacher(teacher3);
        university.addTeacher(teacher4);
    }

    public static void loadStudents(University university){
        Student student1 = university.registerStudent("Joe Gonzalez", 20);
        Student student2 = university.registerStudent("Carlos Leal", 18);
        Student student3 = university.registerStudent("Emilio Navarro", 22);
        Student student4 = university.registerStudent("Carlos Ferro", 25);
        Student student5 = university.registerStudent("Andres Theran", 20);
        Student student6 = university.registerStudent("Felipe Rivas", 27);

        university.addStudent(student1);
        university.addStudent(student2);
        university.addStudent(student3);
        university.addStudent(student4);
        university.addStudent(student5);
        university.addStudent(student6);
    }

    public static void loadSubjects(University university){
        List<Teacher> teacherList = university.getTeacherList();
        List<Student> studentList = university.getStudentList();

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

        university.addSubject(subject1);
        university.addSubject(subject2);
        university.addSubject(subject3);
        university.addSubject(subject4);
    }
}
