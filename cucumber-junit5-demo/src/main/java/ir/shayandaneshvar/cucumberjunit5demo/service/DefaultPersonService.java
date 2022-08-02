package ir.shayandaneshvar.cucumberjunit5demo.service;

import ir.shayandaneshvar.cucumberjunit5demo.model.Person;
import ir.shayandaneshvar.cucumberjunit5demo.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class DefaultPersonService implements PersonService {
    private final PersonRepository personRepository;

    @Override
    public Person findById(Long id) {
        return personRepository.findById(id).orElseThrow();
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Collection<Person> findAll() {
        return personRepository.findAll();
    }
}
