package com.sms.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PermanentInstructor.class, name = "Permanent"),
        @JsonSubTypes.Type(value = VisitingInstructor.class, name = "Visiting")
})
@SuperBuilder
public class Instructor {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private String phoneNumber;


    @JsonManagedReference
    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
    private Set<Course> courses = new HashSet<>();

}
