package com.mapsa.mockitodemo.repo;

import com.mapsa.mockitodemo.domain.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@DataJpaTest
@ActiveProfiles("test")
class StudentRepositoryTest {
    static final String NAME = "Ali", F1 = "reza", F2 = "mina";

    @Autowired
    StudentRepository repository;


    @Test
    void findStudentByNameContainingTest() {
        repository.save(new Student().setName("alireza"));
        Student student = repository.findStudentByNameContaining("ali").stream()
                .findFirst().get();
        Assertions.assertThat(student.getName().contains("ali")).isTrue();
    }

    @Test
    void findStudentFriendsByNameTest() {
        // given
        Student student = new Student().setName(NAME);
        student.getFriends()
                .addAll(List.of(new Student().setName(F1), new Student()
                        .setName(F2)));
        repository.save(student);
        // when
        List<Student> friends = repository.findStudentFriendsByName(NAME);
        //then
        friends.stream()
                .map(Student::getName)
                .forEach(x -> Assertions.assertThat(x.equals(F1) || x
                        .equals(F2)).isTrue());

    }

    @Test
    void findStudentByBefriendedSthByNameTest() {
        // given
        Student student = new Student().setName(NAME), student1 = new Student().setName(F1);
        student.getFriends().add(student1);
        student1.getFriends().add(student);
        Student student2 = new Student().setName(F2);
        student2.getFriends().add(student);
        repository.saveAll(List.of(student1, student2, student));
        //when
        List<Student> students = repository.findStudentByBefriendedSthByName(NAME);
        // then expect
        students.stream()
                .map(Student::getName)
                .peek(System.out::println) // debug
                .forEach(z -> Assertions.assertThat(
                        z.equals(F1) || z.equals(F2)).isTrue());
    }
}
