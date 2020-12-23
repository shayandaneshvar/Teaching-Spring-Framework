package com.mapsa.repo;

import com.mapsa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "delete from _user u where u.name= :name", nativeQuery = false)
    void deleteByName(@Param("name") String name);

    Optional<User> findByEmail(String email);

    Optional<User> findAllByName(String name);
}
