package com.sms.repository;

import com.sms.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    @Query("select s.gender, count(s.gender) from Student s GROUP BY s.gender")
    List<?> getGendersWithGrouping();

    void deleteByName(String name);
}
