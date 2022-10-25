package org.globant.university.data;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String universityName;
    private List<Student> studentList;
    private List<Teacher> teacherList;
    private List<Subject> subjectList;

    public University(String universityName) {
        this.universityName = universityName;
        this.studentList = new ArrayList<>();
        this.teacherList = new ArrayList<>();
        this.subjectList = new ArrayList<>();
    }

    public String getUniversityName() {
        return universityName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void addStudent(Student student){
        this.studentList.add(student);
    }

    public void addTeacher(Teacher teacher){
        this.teacherList.add(teacher);
    }

    public void addSubject(Subject subject){
        this.subjectList.add(subject);
    }
}
