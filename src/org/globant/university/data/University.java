package org.globant.university.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that allows instantiating, accessing and updating all university's needed information.
 */
public class University {
    private String name;
    private List<Student> studentList;
    private List<Teacher> teacherList;
    private List<Subject> subjectList;

    public University(String universityName) {
        this.name = universityName;
        this.studentList = new ArrayList<>();
        this.teacherList = new ArrayList<>();
        this.subjectList = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<Student> getStudentList() {
        return this.studentList;
    }

    public List<Teacher> getTeacherList() {
        return this.teacherList;
    }

    public List<Subject> getSubjectList() {
        return this.subjectList;
    }

    /**
     * Method for creating an instance of the {@link org.globant.university.data.FullTimeTeacher Full-time teacher} class and add it to the university teachers' list.
     * @param teacherName
     * @param baseSalary
     * @param experienceYears
     * @return Full-time teacher that was instanced.
     */
    public FullTimeTeacher registerFullTimeTeacher(String teacherName, float baseSalary, int experienceYears) {
        FullTimeTeacher fullTimeTeacher = new FullTimeTeacher(teacherName, baseSalary, experienceYears);
        this.addTeacher(fullTimeTeacher);
        return fullTimeTeacher;
    }

    /**
     * Method for creating an instance of the {@link org.globant.university.data.PartTimeTeacher Part-time teacher} class and add it to the university teachers' list.
     * @param teacherName
     * @param baseSalary
     * @param weeklyActiveHours
     * @return Part-time teacher that was instanced.
     */
    public PartTimeTeacher registerPartTimeTeacher(String teacherName, float baseSalary, float weeklyActiveHours) {
        PartTimeTeacher partTimeTeacher = new PartTimeTeacher(teacherName, baseSalary, weeklyActiveHours);
        this.addTeacher(partTimeTeacher);
        return partTimeTeacher;
    }

    /**
     * Method for creating an instance of the {@link org.globant.university.data.Student Student} class and add it to the university students' list.
     * @param studentName
     * @param studentAge
     * @return Student that was instanced.
     */
    public Student registerStudent(String studentName, int studentAge) {
        Student student = new Student(studentName, studentAge);
        this.addStudent(student);
        return student;
    }

    /**
     * Method for creating an instance of the {@link org.globant.university.data.Subject Subject} class and add it to the university subjects' list.
     * @param subjectName
     * @param classroom
     * @param teacher It should have been previously created by using either {@link org.globant.university.data.University#registerFullTimeTeacher(String, float, int) registerFullTimeTeacher()} or {@link org.globant.university.data.University#registerPartTimeTeacher(String, float, float) registerPartTimeTeacher()} method
     * @return Subject that was instanced.
     */
    public Subject createSubject(String subjectName, String classroom, Teacher teacher) {
        Subject subject = new Subject(subjectName, classroom, teacher);
        this.addSubject(subject);
        return subject;
    }

    /**
     * Method for creating an instance of the {@link org.globant.university.data.Subject Subject} class with partial information and add it to the university subjects' list.
     * @param subjectName
     * @param classroom
     * @return Subject that was instanced.
     */
    public Subject createTemporalSubject(String subjectName, String classroom) {
        Subject subject = new Subject(subjectName, classroom);
        this.addSubject(subject);
        return subject;
    }

    /**
     * Method for adding a {@link org.globant.university.data.Student Student} to the university students' list.
     * @param student From {@link org.globant.university.data.Student Student}
     */
    public void addStudent(Student student) {
        this.getStudentList().add(student);
    }

    /**
     * Method for adding a {@link org.globant.university.data.Teacher Teacher} to the university teachers' list.
     * @param teacher From {@link org.globant.university.data.Teacher Teacher}
     */
    public void addTeacher(Teacher teacher) {
        this.getTeacherList().add(teacher);
    }

    /**
     * Method for adding a {@link org.globant.university.data.Subject Subject} to the university subjects' list.
     * @param subject From {@link org.globant.university.data.Subject Subject}
     */
    public void addSubject(Subject subject) {
        this.getSubjectList().add(subject);
    }

    /**
     * Method for adding a {@link org.globant.university.data.Student Student} to a given {@link org.globant.university.data.Subject Subject}.
     * @param subject From {@link org.globant.university.data.Subject Subject}
     * @param student From {@link org.globant.university.data.Student Student}
     */
    public void addStudentToSubject(Subject subject,Student student) {
        subject.addStudentToSubject(student);
    }

    /**
     * Method for assigning a {@link org.globant.university.data.Teacher Teacher} to a given {@link org.globant.university.data.Subject Subject}.
     * @param subject From {@link org.globant.university.data.Subject Subject}
     * @param teacher From {@link org.globant.university.data.Teacher Teacher}
     */
    public void assignTeacherToSubject(Subject subject, Teacher teacher) {
        subject.setTeacher(teacher);
    }

    /**
     * Method for finding a {@link org.globant.university.data.Student Student} in the university students' list (array) by its position (index).
     * @param index {@link org.globant.university.data.Student Student} position in the university students' list (array)
     * @return {@link org.globant.university.data.Student Student} found.
     */
    public Student getStudentByIndex(int index) {
        return this.getStudentList().get(index);
    }

    /**
     * Method for finding a {@link org.globant.university.data.Teacher Teacher} in the university teachers' list (array) by its position (index).
     * @param index {@link org.globant.university.data.Teacher Teacher} position in the university teachers' list (array)
     * @return {@link org.globant.university.data.Teacher Teacher} found.
     */
    public Teacher getTeacherByIndex(int index) {
        return this.getTeacherList().get(index);
    }

    /**
     * Method for finding a {@link org.globant.university.data.Subject Subject} in the university subjects' list (array) by its position (index).
     * @param index {@link org.globant.university.data.Subject Subject} position in the university subjects' list (array)
     * @return {@link org.globant.university.data.Subject Subject} found.
     */
    public Subject getSubjectByIndex(int index) {
        return  this.getSubjectList().get(index);
    }

    /**
     * Method for getting the amount of {@link org.globant.university.data.Student Student}s in the university.
     * @return {@link org.globant.university.data.Student Student}s amount as an <em>int</em>.
     */
    public int getStudentsAmount() {
        return this.getStudentList().size();
    }

    /**
     * Method for getting the amount of {@link org.globant.university.data.Teacher Teacher}s in the university.
     * @return {@link org.globant.university.data.Teacher Teacher}s amount as an <em>int</em>.
     */
    public int getTeachersAmount() {
        return this.getTeacherList().size();
    }

    /**
     * Method for getting the amount of {@link org.globant.university.data.Subject Subject}s in the university.
     * @return {@link org.globant.university.data.Subject Subject}s amount as an <em>int</em>.
     */
    public int getSubjectsAmount() {
        return this.getSubjectList().size();
    }

    /**
     * Method for concatenating the names of the {@link org.globant.university.data.Subject Subject}s that are in charge of a certain {@link org.globant.university.data.Teacher Teacher}.
     * @param teacherIndex {@link org.globant.university.data.Teacher Teacher} position in the university teachers' list (array)
     * @return List of {@link org.globant.university.data.Subject Subject}s names as a <em>String</em>.
     */
    public String getSubjectsPerTeacher(int teacherIndex) {
        String assignedSubjects = "";
        int counter = 1;
        String teacherName = getTeacherByIndex(teacherIndex).getName();
        for (int i = 0; i < getSubjectsAmount(); i++) {
            String teacherFoundName = this.getSubjectByIndex(i).getTeacherName();
            if (teacherFoundName.equals(teacherName)) {
                assignedSubjects += "\n" + counter  + ". " + this.getSubjectName(i);
                counter++;
            }
        }
        return assignedSubjects;
    }

    /**
     * Method for concatenating a {@link org.globant.university.data.Teacher Teacher}'s information along with the {@link org.globant.university.data.Subject Subject}s that are in charge of them.
     * @param teacherIndex {@link org.globant.university.data.Teacher Teacher} position in the university teachers' list (array)
     * @return Full {@link org.globant.university.data.Teacher Teacher}'s information as a <em>String</em>.
     */
    public String getTeachersInfo(int teacherIndex) {
        return this.getTeacherByIndex(teacherIndex).toString() + getSubjectsPerTeacher(teacherIndex);
    }

    /**
     * Method for finding a {@link org.globant.university.data.Student Student}'s name from the university students' list (array) by its position (index).
     * @param studentIndex {@link org.globant.university.data.Student Student} position in the university students' list (array)
     * @return {@link org.globant.university.data.Student Student}'s name as a <em>String</em>.
     */
    public String getStudentName(int studentIndex) {
        return this.getStudentByIndex(studentIndex).getName();
    }

    /**
     * Method for finding a {@link org.globant.university.data.Teacher Teacher}'s name from the university teachers' list (array) by its position (index).
     * @param teacherIndex {@link org.globant.university.data.Teacher Teacher} position in the university teachers' list (array)
     * @return {@link org.globant.university.data.Teacher Teacher}'s name as a <em>String</em>.
     */
    public String getTeacherName(int teacherIndex) {
        return this.getTeacherByIndex(teacherIndex).getName();
    }

    /**
     * Method for finding a {@link org.globant.university.data.Subject Subject}'s name from the university subjects' list (array) by its position (index).
     * @param subjectIndex {@link org.globant.university.data.Subject Subject} position in the university subjects' list (array)
     * @return {@link org.globant.university.data.Subject Subject}'s name as a <em>String</em>.
     */
    public String getSubjectName(int subjectIndex) {
        return  this.getSubjectByIndex(subjectIndex).getName();
    }

    /**
     * Method for getting the subject information for a certain {@link org.globant.university.data.Subject Subject} by using {@link Subject#getSubjectInfo()}.
     * @param subjectIndex {@link org.globant.university.data.Subject Subject} position in the university subjects' list (array)
     * @return All {@link org.globant.university.data.Subject Subject} information as a <em>String</em>.
     */
    public String getSubjectsInfo(int subjectIndex) {
        return this.getSubjectByIndex(subjectIndex).getSubjectInfo();
    }

    /**
     * Method for verifying if a {@link org.globant.university.data.Subject Subject} with a certain name has been already created
     * @param subjectName
     * @return A <em>boolean</em> indicating if either a {@link org.globant.university.data.Subject Subject}'s name has been already used.
     */
    public boolean checkSubjectName(String subjectName) {
        boolean existingName = false;
        for (int i = 0; i < this.getSubjectsAmount(); i++) {
            if (this.getSubjectByIndex(i).getName().equals(subjectName)) {
                existingName = true;
            }
        }
        return existingName;
    }

    /**
     * Method of getting the list of {@link org.globant.university.data.Subject Subject}s in which a certain {@link org.globant.university.data.Student Student} is registered.
     * @param studentIndex {@link org.globant.university.data.Student Student} position in the university students' list (array)
     * @return List of {@link org.globant.university.data.Subject Subject}s
     */
    public ArrayList<Subject> getSubjectsPerStudent(int studentIndex) {
        ArrayList subjectsPerStudent = new ArrayList<>();
        for (int i = 0; i < this.getSubjectList().size(); i++) {
            if (this.verifyStudentInSubject(this.getSubjectByIndex(i), studentIndex)) {
                subjectsPerStudent.add(this.getSubjectList().get(i));
            }
        }
        return subjectsPerStudent;
    }

    /**
     * Method for verifying if a student is registered in a given subject.
     * @param subject From {@link org.globant.university.data.Subject Subject}
     * @param studentIndex {@link org.globant.university.data.Student Student} position in the university students' list (array)
     * @return A <em>boolean</em> indicating if either a student is registered in the subject.
     */
    public boolean verifyStudentInSubject(Subject subject, int studentIndex) {
        int studentId = this.getStudentId(studentIndex);
        return subject.verifyStudentInSubject(studentId);
    }

    /**
     * Method for finding a {@link org.globant.university.data.Student Student}'s ID from the university students' list (array) by its position (index).
     * @param studentIndex {@link org.globant.university.data.Student Student} position in the university students' list (array)
     * @return {@link org.globant.university.data.Student Student}'s ID as a <em>int</em>.
     */
    public int getStudentId(int studentIndex) {
        return this.getStudentByIndex(studentIndex).getId();
    }

    /**
     * Method of getting the amount of {@link org.globant.university.data.Subject Subject}s in which a certain {@link org.globant.university.data.Student Student} is registered.
     * @param studentIndex {@link org.globant.university.data.Student Student} position in the university students' list (array)
     * @return Amount of {@link org.globant.university.data.Subject Subject}s as a <em>int</em>.
     */
    public int getSubjectsPerStudentAmount(int studentIndex) {
        return this.getSubjectsPerStudent(studentIndex).size();
    }

    /**
     * Method for getting a certain {@link org.globant.university.data.Subject Subject}'s name from the list of Subjects in which a given {@link org.globant.university.data.Student Student} is registered.
     * @param studentIndex {@link org.globant.university.data.Student Student} position in the university students' list (array)
     * @param subjectIndex {@link org.globant.university.data.Subject Subject} position in a {@link org.globant.university.data.Student Student}'s subjects list (array)
     * @return {@link org.globant.university.data.Subject Subject}'s name as a <em>String</em>.
     */
    public String getSubjectsNamePerStudent(int studentIndex, int subjectIndex) {
        return this.getSubjectsPerStudent(studentIndex).get(subjectIndex).getName();
    }
}
