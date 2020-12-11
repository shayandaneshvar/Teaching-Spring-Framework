package com.mapsa.mockitodemo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data // @Value
@Entity
//@Builder()
@Accessors(chain = true)
@NoArgsConstructor
@Table(name = "STUDENT")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "student_name")
    private String name;
    @Column(name = "student_id")
    private String studentId;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "FRIENDS")
    private List<Student> friends = new ArrayList<>();
}
