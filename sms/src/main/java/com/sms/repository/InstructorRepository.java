package com.sms.repository;

import com.sms.entity.Instructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor,Long> {
    void deleteByName(String name);

    @Query(nativeQuery = true,value = "SELECT Top 3 * FROM Instructor i ORDER BY i.salary ASC")
    List<Instructor> getOrderByAsc();

    @Query(nativeQuery = true, value = "SELECT Top 3 * FROM Instructor i ORDER BY i.salary DESC")
    List<Instructor> getOrderByDesc();
}
