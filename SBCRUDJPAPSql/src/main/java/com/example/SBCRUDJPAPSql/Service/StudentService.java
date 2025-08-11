package com.example.SBCRUDJPAPSql.Service;

import com.example.SBCRUDJPAPSql.Model.Student;
import com.example.SBCRUDJPAPSql.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository repository;

    public List<Student> getAllStudentList() {
        return repository.findAll();
    }

    public void addStudent(Student student) {
        repository.save(student);
    }

    public Student getStudentbyRollNo(int rno) {
        return repository.findById(rno).orElse(null);
    }

    public void updateStudent(Student student) {
        repository.save(student);
    }

    public void deleteStudentbyRno(int rno) {
        repository.deleteById(rno);
    }

    public void deleteAllStudents() {
        repository.deleteAll();
    }

    public List<Student> getStudentbyTechnology(String technology) {
        return repository.findByTechnology(technology);
    }

    public List<Student> getStudentbygenderTechnology(String gender, String technology) {
        return repository.findByGenderTechnology(gender,technology);
    }
}
