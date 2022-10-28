package org.globant.university.data;

public abstract class Teacher {
    protected String teacherName;
    protected double baseSalary;

    public Teacher(String teacherName, float baseSalary) {
        this.teacherName = teacherName;
        this.baseSalary = baseSalary;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public abstract double calculateTeacherSalary();

    @Override
    public abstract String toString();
}
