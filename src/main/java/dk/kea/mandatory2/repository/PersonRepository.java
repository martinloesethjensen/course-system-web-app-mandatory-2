package dk.kea.mandatory2.repository;

import dk.kea.mandatory2.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    Person findAllBySession_id(Integer id);
}
