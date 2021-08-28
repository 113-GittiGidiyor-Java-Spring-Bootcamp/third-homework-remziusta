package com.sms.util;

import com.sms.entity.*;
import com.sms.repository.CourseRepository;
import com.sms.repository.InstructorRepository;
import com.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;

@Component
public class InitializerRunner implements CommandLineRunner {


    CourseRepository courseRepository;

    StudentRepository studentRepository;

    InstructorRepository instructorRepository;

    @Autowired
    public void setInstructorRepository(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Autowired
    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Student s1 = Student.builder().name("Emre Dalcı").address("İSTANBUL").birthDate(LocalDate.of(1996,Month.AUGUST,29)).gender('E').build();
        Student s2 = Student.builder().name("Ahmet Emre Oğuz").address("İSTANBUL").birthDate(LocalDate.of(1996,Month.AUGUST,29)).gender('E').build();
        Student s3 = Student.builder().name("Remzi USTA").address("HATAY").birthDate(LocalDate.of(1996,Month.AUGUST,29)).gender('E').build();

        Instructor i1 = VisitingInstructor.builder().name("Çağlar OFLAZOĞLU").address("HATAY").phoneNumber("05555555555").salary(234.0).build();
        Instructor i2 = PermanentInstructor.builder().name("Koray Güney").address("HATAY").phoneNumber("05555555555").salary(4000.0).build();

        Course c1 = Course.builder().courseName("Fizik-1").courseCode("FZK-1").instructor(i1).courseCredit(5).build();
        Course c2 = Course.builder().courseName("Kimya-1").courseCode("KMY-1").instructor(i2).courseCredit(6).build();

        Course c3 = Course.builder().courseName("Matematik-1").courseCode("MT-1").instructor(i1).courseCredit(5).build();



         Set<Course> sc1 = new HashSet<>();
         sc1.add(c1);
         sc1.add(c2);
         sc1.add(c3);

         s1.setCourses(sc1);

         Set<Course> sc2 = new HashSet<>();
         sc2.add(c1);
         sc2.add(c2);
         s2.setCourses(sc2);

         Set<Course> sc3 = new HashSet<>();
         sc3.add(c2);
         sc3.add(c3);
         s3.setCourses(sc3);

         Set<Student> cs1 = new HashSet<>();
         cs1.add(s1);
         cs1.add(s2);

         c1.setStudents(cs1);

         Set<Student> cs2 = new HashSet<>();
         cs2.add(s1);
         cs2.add(s2);
         cs2.add(s3);

         c2.setStudents(cs2);

         Set<Student> cs3 = new HashSet<>();
         cs3.add(s3);
         c3.setStudents(cs3);

         Set<Course> ic1 = new HashSet<>();
         ic1.add(c1);
         ic1.add(c3);
         i1.setCourses(ic1);

         Set<Course> ic2 = new HashSet<>();
         ic2.add(c2);
         i2.setCourses(ic2);




        instructorRepository.save(i1);
        instructorRepository.save(i2);

        courseRepository.save(c1);
        courseRepository.save(c2);
        courseRepository.save(c3);

        studentRepository.save(s1);
        studentRepository.save(s2);
        studentRepository.save(s3);



    }
}
