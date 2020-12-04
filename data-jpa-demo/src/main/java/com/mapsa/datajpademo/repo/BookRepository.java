package com.mapsa.datajpademo.repo;

import com.mapsa.datajpademo.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RepositoryRestResource(exported = true, path = "book-repo")
public interface BookRepository extends JpaRepository<Book, Long> {
    @RestResource(path = "findBookByName")
    Optional<Book> findBookByNameContaining(@Param("bookName") String name);

    @RestResource(exported = false)
    void deleteInBatch(Iterable<Book> var1);

    @RestResource(exported = false)
    void deleteAllInBatch();

    @RestResource(exported = false)
    void deleteById(Long id);


    @RestResource(exported = false)
    void delete(Book entity);
//    Integer countBy
//    Boolean existsByName
//    void deleteBy
}
