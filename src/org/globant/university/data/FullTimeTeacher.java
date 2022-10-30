package org.globant.university.data;

/**
 * Class for the kind of teacher whose salary is calculated based on their experience years.
 * <br/>
 * It allows instantiating, accessing and updating all full-time teachers needed information.
 */
public class FullTimeTeacher extends Teacher {
    private int experienceYears;

    public FullTimeTeacher(String teacherName, float baseSalary, int experienceYears) {
        super(teacherName, baseSalary);
        this.experienceYears = experienceYears;
    }

    public int getExperienceYears() {
        return this.experienceYears;
    }

    public double calculateTeacherSalary() {
        return super.getBaseSalary() * 1.1 * this.getExperienceYears();
    }

    @Override
    public String toString() {
        return "ID: " + super.getId() + "\nName: " + super.getName() + "\nType: Full time teacher" +"\nExperience years: " + this.getExperienceYears() + "\nBase salary: " + super.getBaseSalary() + "\nActual salary: " + this.calculateTeacherSalary() + "\nSubjects in charge: ";
    }
}
