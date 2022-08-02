package ir.shayandaneshvar.cucumberjunit5demo.service;

import ir.shayandaneshvar.cucumberjunit5demo.model.Person;

import java.util.Collection;

public interface PersonService {

    Person findById(Long id);

    Person save(Person person);

    Collection<Person> findAll();
}
