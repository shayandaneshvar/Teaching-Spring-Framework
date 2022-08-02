package ir.shayandaneshvar.cucumberjunit5demo.repository;

import java.util.Collection;
import java.util.Optional;

//@NoRepositoryBean
public interface GenericRepository<T,ID> {
    T save(T t);

    Optional<T> findById(ID id);

    Collection<T> findAll();

    void deleteById(ID id);

    void deleteAll();
    // other methods
}
