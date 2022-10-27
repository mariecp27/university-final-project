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
        return (super.baseSalary / 192 ) * this.weeklyActiveHours * 4;
    }

    @Override
    public String toString() {
        return "Name: " + super.getTeacherName() + "\nType: Part time teacher" +"\nWeekly active hours: " + this.getWeeklyActiveHours() + "\nBase salary: " + super.getBaseSalary() + "\nActual salary: " + this.calculateTeacherSalary() + "\nSubjects in charge: ";
    }
}
