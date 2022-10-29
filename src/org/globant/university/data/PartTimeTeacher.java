package org.globant.university.data;

/**
 * Class for the kind of teacher whose salary is calculated based on their weekly working hours.
 * <br/>
 * It allows instantiating, accessing and updating all part-time teachers needed information.
 */
public class PartTimeTeacher extends Teacher {
    private float weeklyActiveHours;

    public PartTimeTeacher(String teacherName, float baseSalary, float weeklyActiveHours) {
        super(teacherName, baseSalary);
        this.weeklyActiveHours = weeklyActiveHours;
    }

    public float getWeeklyActiveHours() {
        return this.weeklyActiveHours;
    }

    public double calculateTeacherSalary() {
        return (super.getBaseSalary() / 192 ) * this.getWeeklyActiveHours() * 4;
    }

    @Override
    public String toString() {
        return "ID: " + super.getId() + "\nName: " + super.getName() + "\nType: Part time teacher" +"\nWeekly active hours: " + this.getWeeklyActiveHours() + "\nBase salary: " + super.getBaseSalary() + "\nActual salary: " + this.calculateTeacherSalary() + "\nSubjects in charge: ";
    }
}
