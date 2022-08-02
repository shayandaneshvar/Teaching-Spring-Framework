package ir.shayandaneshvar.cucumberjunit5demo.repository;

import ir.shayandaneshvar.cucumberjunit5demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PersonDao implements PersonRepository {
    private final AtomicLong counter = new AtomicLong(1);
    private final Map<Long, Person> people = new HashMap<>();

    @Override
    public Person save(Person person) {
        var id = Optional.ofNullable(person.getId())
                .orElseGet(counter::getAndIncrement);
        people.put(id, person.setId(id));
        return person;
    }

    @Override
    public Optional<Person> findById(Long id) {
        return Optional.ofNullable(people.get(id));
    }

    @Override
    public Collection<Person> findAll() {
        return people.values();
    }

    @Override
    public void deleteById(Long id) {
        people.remove(id);
    }

    @Override
    public void deleteAll() {
        people.clear();
    }
}
