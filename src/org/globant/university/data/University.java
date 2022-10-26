package org.globant.university.data;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String universityName;
    private List<Student> studentList;
    private List<Teacher> teacherList;
    private List<Subject> subjectList;

    public University(String universityName) {
        this.universityName = universityName;
        this.studentList = new ArrayList<>();
        this.teacherList = new ArrayList<>();
        this.subjectList = new ArrayList<>();
    }

    public String getUniversityName() {
        return universityName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public FullTimeTeacher registerFullTimeTeacher(String teacherName, float baseSalary, int experienceYears) {
        return new FullTimeTeacher(teacherName, baseSalary, experienceYears);
    }

    public PartTimeTeacher registerPartTimeTeacher(String teacherName, float baseSalary, float weeklyActiveHours) {
        return new PartTimeTeacher(teacherName, baseSalary, weeklyActiveHours);
    }

    public Student registerStudent(String studentName, int studentAge){
        return new Student(studentName, studentAge);
    }

    public Subject createSubject(String subjectName, String classRoom, Teacher teacher){
        return new Subject(subjectName, classRoom, teacher);
    }

    public void addStudent(Student student){
        this.studentList.add(student);
    }

    public void addTeacher(Teacher teacher){
        this.teacherList.add(teacher);
    }

    public void addSubject(Subject subject){
        this.subjectList.add(subject);
    }

    public void addStudentToSubject(Subject subject,Student student){
        subject.addStudentToSubject(student);
    }

    public Student getStudentByIndex(int index){
        return studentList.get(index);
    }

    public Teacher getTeacherByIndex(int index){
        return teacherList.get(index);
    }

    public int getStudentsAmount(){
        return studentList.size();
    }

    public int getTeachersAmount(){
        return teacherList.size();
    }

    public int getSubjectsAmount(){
        return subjectList.size();
    }

    public String getSubjectsPerTeacher(int teacherIndex){
        String assignedSubjects = "";
        int counter = 1;
        Teacher teacher = getTeacherByIndex(teacherIndex);
        for (int i = 0; i < getSubjectsAmount(); i++) {
            Teacher teacherFound = subjectList.get(i).getTeacher();
            if (teacherFound == teacher){
                assignedSubjects += "\n" + " " + counter  + ". " + subjectList.get(i).getSubjectName();
                counter++;
            }
        }
        return assignedSubjects;
    }

    public String getTeachersInfo(int teacherIndex){
        return  this.getTeacherByIndex(teacherIndex).toString() + getSubjectsPerTeacher(teacherIndex);
    }
}
