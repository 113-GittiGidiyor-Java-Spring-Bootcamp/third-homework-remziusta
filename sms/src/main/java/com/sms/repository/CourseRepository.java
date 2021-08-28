package com.sms.repository;

import com.sms.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course,Long> {

    void deleteByCourseName(String courseName);
}
