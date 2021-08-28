package com.sms.controller;

import com.sms.entity.Course;
import com.sms.repository.CourseRepository;
import com.sms.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/course")
public class CourseController {

    CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("")
    public ResponseEntity<List<Course>> showAllCourse(){
        return new ResponseEntity(courseService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> showCourse(@PathVariable Long id){
        return new ResponseEntity<>(courseService.findById(id), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseService.save(course), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseService.update(course),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id){
        courseService.deleteById(id);
        return new ResponseEntity<>("Delete Course...", HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteByCourseName(@RequestParam String courseName){
        courseService.deleteByCourseName(courseName);
        return new ResponseEntity<>("Delete " + courseName, HttpStatus.OK);
    }
}
