package groomthon.sanghyeon.basic.service;

import groomthon.sanghyeon.basic.entity.Student;
import groomthon.sanghyeon.basic.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    public Student addStudent(String name, int grade) {
        Student student = new Student(name,grade);
        studentRepository.add(student);
        return student;
    }
    public List<Student> getAll() {
        return studentRepository.getSorted();
    }
    public List<Student> get(int grade) {
        return studentRepository.get(grade);
    }
}
