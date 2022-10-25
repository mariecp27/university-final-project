package org.globant.university.data;

public class Student {
    private int studentId;
    private String studentName;
    private int studentAge;

    public Student(String studentName, int studentAge) {
        this.studentId = (int)(Math.random() * 1000);
        this.studentName = studentName;
        this.studentAge = studentAge;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }
}
