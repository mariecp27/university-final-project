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
        return this.studentList.get(index);
    }

    public Teacher getTeacherByIndex(int index){
        return this.teacherList.get(index);
    }

    public Subject getSubjectByIndex(int index){
        return  this.subjectList.get(index);
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
        String teacherName = getTeacherByIndex(teacherIndex).getTeacherName();
        for (int i = 0; i < getSubjectsAmount(); i++) {
            String teacherFound = subjectList.get(i).getTeacherName();
            if (teacherFound.equals(teacherName)){
                assignedSubjects += "\n" + " " + counter  + ". " + subjectList.get(i).getSubjectName();
                counter++;
            }
        }
        return assignedSubjects;
    }

    public String getTeachersInfo(int teacherIndex){
        return  this.getTeacherByIndex(teacherIndex).toString() + getSubjectsPerTeacher(teacherIndex);
    }

    public String getSubjectName(int subjectIndex){
        return  this.getSubjectByIndex(subjectIndex).getSubjectName();
    }

    public String getSubjectsInfo(int subjectIndex){
        return this.getSubjectByIndex(subjectIndex).getSubjectInfo();
    }
}
