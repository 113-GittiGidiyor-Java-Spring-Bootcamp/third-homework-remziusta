package com.sms.service;

import com.sms.entity.Student;
import com.sms.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements BaseService<Student> {

    StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Student> findAll() {
        List<Student> myList = new ArrayList<>();
        Iterable<Student> iterable = studentRepository.findAll();
        iterable.iterator().forEachRemaining(myList::add);
        return myList;
    }

    @Transactional(readOnly = true)
    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Transactional
    @Override
    public Student save(Student object) {
        return studentRepository.save(object);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Student update(Student object) {
        return studentRepository.save(object);
    }

    public List<?> getAgesWithGrouping() {
        return studentRepository.getGendersWithGrouping();
    }

    @Transactional
    public void deleteByName(String name){
        studentRepository.deleteByName(name);
    }


}
