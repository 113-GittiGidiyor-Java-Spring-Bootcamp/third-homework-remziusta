package com.sms.controller;

import com.sms.entity.Student;
import com.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("")
    public ResponseEntity<List<Student>> showAllStudent(){
        return new ResponseEntity(studentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/group")
    public ResponseEntity<List<?>> showGroupList(){
        return new ResponseEntity<>(studentService.getAgesWithGrouping(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> showStudent(@PathVariable Long id){
        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.save(student), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.update(student),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        studentService.deleteById(id);
        return new ResponseEntity<>("Delete Student...", HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<String> deleteByName(@RequestParam String name){
        studentService.deleteByName(name);
        return new ResponseEntity<>("Delete " + name, HttpStatus.OK);
    }
}
