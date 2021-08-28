package com.sms.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
@Builder
public class Course {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;

    private Integer courseCredit;

    private String courseCode;

    @ManyToMany(mappedBy = "courses",cascade = CascadeType.ALL)
    private Set<Student> students = new HashSet<>();

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_id", nullable = true)
    private Instructor instructor;

}
