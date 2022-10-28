package org.globant.university.data;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private String subjectName;
    private String classRoom;
    private List<Student> studentList;
    private Teacher teacher;

    public Subject(){

    }

    public Subject(String subjectName, String classRoom){
        this.subjectName = subjectName;
        this.classRoom = classRoom;
        this.studentList = new ArrayList<>();
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

    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
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
            assignedStudents += "\n" + " " + counter  + ". " + studentList.get(i).toString();
            counter++;
        }
        return assignedStudents;
    }

    public String getSubjectInfo() {
        return "Name: " + this.getSubjectName() + "\nClassroom: " + this.getClassRoom() + "\nTeacher in charge: " + this.getTeacherName() + "\nStudents in the course: " + this.getStudentsPerSubject();
    }

    public boolean verifyStudentInSubject(int studentId){
        boolean isStudent = false;
        for (int i = 0; i < this.getStudentList().size(); i++) {
            if (this.getStudentList().get(i).getStudentId() == studentId) {
                isStudent = true;
            }
        }
        return isStudent;
    }
}
