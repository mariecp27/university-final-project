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

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public FullTimeTeacher registerFullTimeTeacher(String teacherName, float baseSalary, int experienceYears) {
        FullTimeTeacher fullTimeTeacher = new FullTimeTeacher(teacherName, baseSalary, experienceYears);
        this.addTeacher(fullTimeTeacher);
        return fullTimeTeacher;
    }

    public PartTimeTeacher registerPartTimeTeacher(String teacherName, float baseSalary, float weeklyActiveHours) {
        PartTimeTeacher partTimeTeacher = new PartTimeTeacher(teacherName, baseSalary, weeklyActiveHours);
        this.addTeacher(partTimeTeacher);
        return partTimeTeacher;
    }

    public Student registerStudent(String studentName, int studentAge){
        Student student = new Student(studentName, studentAge);
        this.addStudent(student);
        return student;
    }

    public Subject createSubject(String subjectName, String classroom, Teacher teacher){
        Subject subject = new Subject(subjectName, classroom, teacher);
        this.addSubject(subject);
        return subject;
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

    public void assignTeacherToSubject(Subject subject, Teacher teacher){
        subject.setTeacher(teacher);
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
                assignedSubjects += "\n" + " " + counter  + ". " + this.getSubjectName(i);
                counter++;
            }
        }
        return assignedSubjects;
    }

    public String getTeachersInfo(int teacherIndex){
        return this.getTeacherByIndex(teacherIndex).toString() + getSubjectsPerTeacher(teacherIndex);
    }

    public String getTeacherName(int teacherIndex){
        return this.getTeacherByIndex(teacherIndex).getTeacherName();
    }

    public String getSubjectName(int subjectIndex){
        return  this.getSubjectByIndex(subjectIndex).getSubjectName();
    }

    public String getSubjectsInfo(int subjectIndex){
        return this.getSubjectByIndex(subjectIndex).getSubjectInfo();
    }

    public String getStudentName(int studentIndex){
        return this.getStudentByIndex(studentIndex).getStudentName();
    }

    public Subject createTemporalSubject(String subjectName, String classroom){
        Subject subject = new Subject(subjectName, classroom);
        this.addSubject(subject);
        return subject;
    }

    public boolean checkSubjectName(String subjectName){
        boolean existingName = false;
        for (int i = 0; i < this.getSubjectsAmount(); i++) {
            if (this.getSubjectByIndex(i).getSubjectName().equals(subjectName)){
                existingName = true;
            }
        }
        return existingName;
    }

    public ArrayList<Subject> getSubjectsPerStudent(int studentIndex){
        int studentId = this.getStudentId(studentIndex);
        ArrayList subjectsPerStudent = new ArrayList<>();
        for (int i = 0; i < this.getSubjectList().size(); i++) {
            if(this.getSubjectList().get(i).verifyStudentInSubject(studentId)){
                subjectsPerStudent.add(this.getSubjectList().get(i));
            }
        }
        return subjectsPerStudent;
    }

    public int getStudentId(int studentIndex){
        return this.getStudentByIndex(studentIndex).getStudentId();
    }

    public int subjectsPerStudentAmount(int studentIndex){
        return this.getSubjectsPerStudent(studentIndex).size();
    }

    public String subjectsNamePerStudent(int studentIndex, int subjectIndex){
        return this.getSubjectsPerStudent(studentIndex).get(subjectIndex).getSubjectName();
    }
}
