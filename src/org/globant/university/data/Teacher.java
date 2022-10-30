package org.globant.university.data;

/**
 * Abstract class to be extended by the different kind of teachers:
 * <ul>
 *     <li>{@link org.globant.university.data.FullTimeTeacher Full-time teacher}.</li>
 *     <li>{@link org.globant.university.data.PartTimeTeacher Part-time teacher}.</li>
 * </ul>
 */
public abstract class Teacher {
    protected int id;
    protected String name;
    protected double baseSalary;

    public Teacher(String teacherName, float baseSalary) {
        this.id = (int)(Math.random() * 1000);
        this.name = teacherName;
        this.baseSalary = baseSalary;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getBaseSalary() {
        return this.baseSalary;
    }

    /**
     * Abstract method to be defined in the different kind of teachers for getting the actual teacher salary based on their {@link org.globant.university.data.Teacher#baseSalary base salary}:
     * <ul>
     *     <li>{@link org.globant.university.data.FullTimeTeacher Full-time teacher} : It is calculated by using the teacher experience years.</li>
     *     <li>{@link org.globant.university.data.PartTimeTeacher Part-time teacher}: It is calculated by using the teacher weekly active hours.</li>
     * </ul>
     * @return Actual teacher salary.
     */
    public abstract double calculateTeacherSalary();

    /**
     * Abstract method to be defined in the different kind of teachers for getting the teacher information:
     * <ul>
     *     <li>Teacher name.</li>
     *     <li>Teacher type (full/part time).</li>
     *     <li>Experience years or active weekly hours (depending on the teacher type).</li>
     *     <li>Base salary.</li>
     *     <li>Actual salary.</li>
     * </ul>
     * <strong>Note: </strong> It is concatenated with the subjects the teacher is in charge of ({@link org.globant.university.data.University#getSubjectsPerTeacher}).
     * @return Teacher information.
     */
    @Override
    public abstract String toString();
}
