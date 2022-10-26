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
        return super.actualSalary = super.baseSalary * 1.1 * this.experienceYears;
    }

    @Override
    public String toString() {
        return "Name: " + super.getTeacherName() + "\nType: Full time teacher" +"\nExperience years: " + this.getExperienceYears() + "\nSubjects in charge: ";
    }
}
