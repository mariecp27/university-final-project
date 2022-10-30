package org.globant.university.persistence;

import org.globant.university.data.*;

import java.util.List;

/**
 * Class to instantiate a {@link org.globant.university.data.University University} along with the initial information for:
 * <ul>
 *     <li>Full-time teachers</li>
 *     <li>Part-time teachers</li>
 *     <li>Students</li>
 *     <li>Subjects</li>
 * </ul>
 */
public class DataInitializer {
    /**
     * Method that allows instantiating a {@link org.globant.university.data.University University} long with the initial information for:
     *  <ul>
     *      <li>Full-time teachers</li>
     *      <li>Part-time teachers</li>
     *      <li>Students</li>
     *      <li>Subjects</li>
     *  </ul>
     * @return {@link org.globant.university.data.University University} with all initial information
     */
    public static University loadUniversity() {
        University university = new University("Globant University");

        loadFullTimeTeachers(university);
        loadPartTimeTeachers(university);
        loadStudents(university);
        loadSubjects(university);

        return university;
    }

    /**
     * Method for adding the initial full-time teachers' information.
     * @param university From {@link org.globant.university.data.University University}
     */
    public static void loadFullTimeTeachers(University university) {
        university.registerFullTimeTeacher("Eduardo Perea", 2000000, 5);
        university.registerFullTimeTeacher("Liliana Restrepo", 5000000, 8);
    }

    /**
     * Method for adding the initial part-time teachers' information.
     * @param university From {@link org.globant.university.data.University University}
     */
    public static void loadPartTimeTeachers(University university) {
        university.registerPartTimeTeacher("Maria Lopez", 1500000, 48);
        university.registerPartTimeTeacher("Pedro Lopera", 2000000, 40);
    }

    /**
     * Method for adding the initial students' information.
     * @param university From {@link org.globant.university.data.University University}
     */
    public static void loadStudents(University university) {
        university.registerStudent("Joe Gonzalez", 20);
        university.registerStudent("Carlos Leal", 18);
        university.registerStudent("Emilio Navarro", 22);
        university.registerStudent("Carlos Ferro", 25);
        university.registerStudent("Andres Theran", 20);
        university.registerStudent("Felipe Rivas", 27);
    }

    /**
     * Method for adding the initial subjects' information.
     * @param university From {@link org.globant.university.data.University University}
     */
    public static void loadSubjects(University university) {
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
