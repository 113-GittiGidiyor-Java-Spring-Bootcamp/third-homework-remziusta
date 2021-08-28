package com.sms.service;

import com.sms.entity.Instructor;
import com.sms.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService implements BaseService<Instructor> {

    InstructorRepository instructorRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Instructor> findAll() {
        List<Instructor> myList = new ArrayList<>();
        Iterable<Instructor> iterable = instructorRepository.findAll();
        iterable.iterator().forEachRemaining(myList::add);
        return myList;
    }

    @Transactional(readOnly = true)
    @Override
    public Instructor findById(Long id) {
        return instructorRepository.findById(id).get();
    }

    @Transactional
    @Override
    public Instructor save(Instructor object) {
        return instructorRepository.save(object);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        instructorRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Instructor update(Instructor object) {
        return instructorRepository.save(object);
    }

    @Transactional
    public void deleteByName(String name){
        instructorRepository.deleteByName(name);
    }

    public List<Instructor> getOrderByAsc(){
        return instructorRepository.getOrderByAsc();
    }

    public List<Instructor> getOrderByDesc(){
        return instructorRepository.getOrderByDesc();
    }
}
