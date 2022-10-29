package org.globant.university.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that allows instantiating, accessing and updating all university's subjects/courses needed information.
 */
public class Subject {
    private String name;
    private String classroom;
    private List<Student> studentList;
    private Teacher teacher;

    /**
     * First Subject constructor method.
     * <br/>
     * It allows instantiating a subject with partial information: name, classroom, and student list. The teacher can be added later by using the method {@link org.globant.university.data.Subject#setTeacher(Teacher) setTeacher()}
     * @param subjectName
     * @param classroom
     */
    public Subject(String subjectName, String classroom) {
        this.name = subjectName;
        this.classroom = classroom;
        this.studentList = new ArrayList<>();
    }

    /**
     * Second Subject constructor method.
     * <br/>
     * It allows instantiating a subject with the all needed information: name, classroom, student list, and teacher.
     * @param subjectName
     * @param classroom
     * @param teacher From {@link org.globant.university.data.Teacher Teacher}
     */
    public Subject(String subjectName, String classroom, Teacher teacher) {
        this.name = subjectName;
        this.classroom = classroom;
        this.studentList = new ArrayList<>();
        this.teacher = teacher;
    }

    public String getName() {
        return this.name;
    }

    public String getClassroom() {
        return this.classroom;
    }

    public List<Student> getStudentList() {
        return this.studentList;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     * Method for returning the {@link org.globant.university.data.Teacher Teacher} name of a certain Subject.
     * @return {@link org.globant.university.data.Teacher Teacher} name as a <em>String</em>.
     */
    public String getTeacherName() {
        return this.getTeacher().getName();
    }

    /**
     * Method for adding a {@link org.globant.university.data.Student Student} to the Subject students' list.
     * @param student From {@link org.globant.university.data.Student Student}
     */
    public void addStudentToSubject(Student student) {
        this.getStudentList().add(student);
    }

    /**
     * Method for concatenating the students information that are registered in a subject as a list, by using the method {@link Student#toString()}
     * @return Students' information that are registered in certain subject as a <em>String</em>.
     */
    public String getStudentsPerSubject() {
        String assignedStudents = "";
        int counter = 1;
        for (int i = 0; i < this.getStudentList().size(); i++) {
            assignedStudents += "\n" + counter  + ". " + this.getStudentList().get(i).toString();
            counter++;
        }
        return assignedStudents;
    }

    /**
     * Method for concatenating the subject information:
     * <ul>
     *     <li>Subject name.</li>
     *     <li>Subject classroom.</li>
     *     <li>Teacher in charge.</li>
     *     <li>Students list registered in the subject.</li>
     * </ul>
     * @return All subject information as a <em>String</em>.
     */
    public String getSubjectInfo() {
        return "Name: " + this.getName() + "\nClassroom: " + this.getClassroom() + "\nTeacher in charge: " + this.getTeacherName() + "\nStudents in the course: " + this.getStudentsPerSubject();
    }

    /**
     * Method for verifying if a student is registered in certain subject by inserting the student's ID.
     * @param studentId
     * @return A <em>boolean</em> indicating if either a student is registered in the subject.
     */
    public boolean verifyStudentInSubject(int studentId) {
        boolean isStudent = false;
        for (int i = 0; i < this.getStudentList().size(); i++) {
            if (this.getStudentList().get(i).getId() == studentId) {
                isStudent = true;
            }
        }
        return isStudent;
    }
}
