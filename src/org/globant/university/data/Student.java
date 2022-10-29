package org.globant.university.data;

/**
 * Class that allows instantiating, accessing and updating all university's students needed information.
 */
public class Student {
    private int id;
    private String name;
    private int age;

    public Student(String studentName, int studentAge) {
        this.id = (int)(Math.random() * 1000);
        this.name = studentName;
        this.age = studentAge;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    /**
     * Method for concatenating the student information:
     * <ul>
     *     <li>Student ID.</li>
     *     <li>Student name.</li>
     *     <li>Student age.</li>
     * </ul>
     * @return All student information as a <em>String</em>.
     */
    @Override
    public String toString() {
        return "ID: " + this.getId() + " - Name: " + this.getName() + " - Age: " + this.getAge();
    }
}
