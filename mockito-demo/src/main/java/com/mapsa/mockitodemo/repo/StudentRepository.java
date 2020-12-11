package com.mapsa.mockitodemo.repo;

import com.mapsa.mockitodemo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    //Student findMyStudentById(Long id);
    List<Student> findStudentByNameContaining(String name);

    @Query("select c.friends from Student c join c.friends where c.name = :username")
    List<Student> findStudentFriendsByName(String username);

    @Query(value = "select * from student where id in (select " +
            "f.student_id from student s join  friends f" +
            " on s.id = f.friends_id where s.student_name=" +
            " :username)", nativeQuery = true)
            
//    @Query(value = "(select " +
//            "d.id,d.student_name,d.student_id from (student s join " +
//            "friends f" +
//            " on s.id = f.friends_id) join student d on d.id = f.student_id " +
//            "where s.student_name= :username)", nativeQuery = true)
    List<Student> findStudentByBefriendedSthByName(String username);
}
