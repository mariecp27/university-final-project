package org.globant.university.data;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private String subjectName;
    private String classRoom;
    private List<Student> studentList;
    private Teacher teacher;

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

    public Teacher getTeacher() {
        return teacher;
    }

    public void addStudentToSubject(Student student){
        this.studentList.add(student);
    }

}
