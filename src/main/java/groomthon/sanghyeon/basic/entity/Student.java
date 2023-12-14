package groomthon.sanghyeon.basic.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Student implements Comparable<Student> {
    private String name;
    private int grade;
    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
    @Override
    public int compareTo(Student student) {
        return this.grade - student.getGrade();
    }
}
