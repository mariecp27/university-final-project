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
        return super.baseSalary * this.weeklyActiveHours;
    }
}
