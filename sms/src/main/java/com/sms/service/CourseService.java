package com.sms.service;

import com.sms.entity.Course;
import com.sms.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService implements BaseService<Course>{

    CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Course> findAll() {
        List<Course> myList = new ArrayList<>();
        Iterable<Course> iterable = courseRepository.findAll();
        iterable.iterator().forEachRemaining(myList::add);
        return myList;
    }

    @Transactional(readOnly = true)
    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).get();
    }

    @Transactional
    @Override
    public Course save(Course object) {
        return courseRepository.save(object);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Course update(Course object) {
        return courseRepository.save(object);
    }

    @Transactional
    public void deleteByCourseName(String courseName){
        courseRepository.deleteByCourseName(courseName);
    }
}
