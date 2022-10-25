package org.globant.university.data;

public class FullTimeTeacher extends Teacher{
    private int experienceYears;

    public FullTimeTeacher(String teacherName, float baseSalary, int experienceYears) {
        super(teacherName, baseSalary);
        this.experienceYears = experienceYears;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public double calculateTeacherSalary(){
        return super.baseSalary * 1.1 * this.experienceYears;
    }
}
