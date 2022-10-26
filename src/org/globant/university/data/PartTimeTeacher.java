package org.globant.university.data;

public class PartTimeTeacher extends Teacher{
    private float weeklyActiveHours;

    public PartTimeTeacher(String teacherName, float baseSalary, float weeklyActiveHours) {
        super(teacherName, baseSalary);
        this.weeklyActiveHours = weeklyActiveHours;
    }

    public float getWeeklyActiveHours() {
        return weeklyActiveHours;
    }

    public double calculateTeacherSalary(){
        return super.actualSalary = super.baseSalary * this.weeklyActiveHours;
    }

    @Override
    public String toString() {
        return "Name: " + super.getTeacherName() + "\nType: Part time teacher" +"\nWeekly active hours: " + this.getWeeklyActiveHours() + "\nSubjects in charge: ";
    }
}
