package com.sms.controller;

import com.sms.entity.Instructor;
import com.sms.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

    InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("")
    public ResponseEntity<List<Instructor>> showAllInstructor(){
        return new ResponseEntity(instructorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> showInstructor(@PathVariable Long id){
        return new ResponseEntity<>(instructorService.findById(id), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Instructor> addInstructor(@RequestBody Instructor instructor){
        return new ResponseEntity<>(instructorService.save(instructor), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Instructor> updateInstructor(@RequestBody Instructor instructor){
        return new ResponseEntity<>(instructorService.update(instructor),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInstructor(@PathVariable Long id){
        instructorService.deleteById(id);
        return new ResponseEntity<>("Delete Instructor...", HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<String> deleteByName(@RequestParam String name){
        instructorService.deleteByName(name);
        return new ResponseEntity<>("Delete " + name, HttpStatus.OK);
    }

    @GetMapping("/asc")
    public ResponseEntity<List<Instructor>> getOrderByAsc(){
        return new ResponseEntity<>(instructorService.getOrderByAsc(), HttpStatus.OK);
    }

    @GetMapping("/desc")
    public ResponseEntity<List<Instructor>> getOrderByDesc(){
        return new ResponseEntity<>(instructorService.getOrderByDesc(), HttpStatus.OK);
    }
}
