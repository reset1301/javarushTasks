package com.javarush.task.task29.task2909.human;

import java.util.LinkedList;
import java.util.List;

public class University
//        extends Student {
{
    private List<Student>students;
    private String name;
    private int age;

    public University(String name,int age) {
        this.name = name;
        this.age = age;
        this.students = new LinkedList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public int getAge() {
        return age;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }
    //    public University(String name, int age) {
//        super(name, age, 0);
//    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        for (Student st:students
             ) {
            if (st.getAverageGrade()==averageGrade)
                return st;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        double max = -1;
        for (Student st:students
             ) {
            if (max<st.getAverageGrade())
                max = st.getAverageGrade();
        }
        for (Student st:students
             ) {
            if (max==st.getAverageGrade())
                return st;
        }
        return null;
    }
    public Student getStudentWithMinAverageGrade() {
        double min = 1000;
        for (Student st:students
                ) {
            if (min>st.getAverageGrade())
                min = st.getAverageGrade();
        }
        for (Student st:students
                ) {
            if (min==st.getAverageGrade())
                return st;
        }
        return null;
    }
    public void expel(Student student) {
        students.remove(student);
    }
//    public void getStudentWithMinAverageGradeAndExpel() {
        //TODO:
//    }
}