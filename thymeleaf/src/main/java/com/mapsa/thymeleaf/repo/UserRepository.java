package com.mapsa.thymeleaf.repo;

import com.mapsa.thymeleaf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "delete from _user u where u.name= :name", nativeQuery = false)
    void deleteByName(@Param("name") String name);
}
