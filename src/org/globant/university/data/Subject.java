package org.globant.university.data;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Subject {
    private String subjectName;
    private String classRoom;
    private List<Student> studentList;
    private Teacher teacher;

    public Subject(){

    }

    public Subject(String subjectName, String classRoom, Teacher teacher) {
        this.subjectName = subjectName;
        this.classRoom = classRoom;
        this.studentList = new ArrayList<>();
        this.teacher = teacher;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public String getTeacherName() {
        return teacher.getTeacherName();
    }

    public void addStudentToSubject(Student student){
        this.studentList.add(student);
    }

    public String getStudentsPerSubject(){
        String assignedStudents = "";
        int counter = 1;
        for (int i = 0; i < this.getStudentList().size(); i++) {
            assignedStudents += "\n" + " " + counter  + ". " + studentList.get(i).getStudentName();
            counter++;
        }
        return assignedStudents;
    }

    public String getSubjectInfo() {
        return "Name: " + this.getSubjectName() + "\nClassroom: " + this.getClassRoom() + "\nTeacher in charge: " + this.getTeacherName() + "\nStudents in the course: " + this.getStudentsPerSubject();
    }
}
