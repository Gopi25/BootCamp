package com.example.SBCRUDJPAPSql.Controller;

import com.example.SBCRUDJPAPSql.Model.Student;
import com.example.SBCRUDJPAPSql.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService service;

    @GetMapping("/students")
    public List<Student> getAllStudentList(){
        return service.getAllStudentList();
    }
    @GetMapping("/students/{rno}")
    public ResponseEntity<Student> getStudentIdByRollNo(@PathVariable("rno") int rno){
        Student student= service.getStudentbyRollNo(rno);
        if(student == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student,HttpStatus.OK);
    }
    @PostMapping("/students")
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        service.addStudent(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/students")
    public String updateStudent(@RequestBody Student student){
        service.updateStudent(student);
        return "updated";
    }
    @DeleteMapping("/students/{rno}")
    public String deleteStudentbyRno(@PathVariable int rno){
        service.deleteStudentbyRno(rno);
        return "deleted particular Student";
    }
    @DeleteMapping("/students/clear")
    public String deleteAllStudents(){
        service.deleteAllStudents();
        return "cleared all students";
    }
    @GetMapping("/students/technology/{tech}")
    public List<Student> getStudentbyTechnology(@PathVariable ("tech") String technology){
        return service.getStudentbyTechnology(technology);
    }
    @PostMapping("/students/filter")
    public List<Student> getStudentbygenderTechnology(@Param("gender") String gender,@Param("technology") String technology){
    return service.getStudentbygenderTechnology(gender,technology);
    }
}
