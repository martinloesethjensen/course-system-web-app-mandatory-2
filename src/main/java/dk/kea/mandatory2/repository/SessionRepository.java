package dk.kea.mandatory2.repository;

import dk.kea.mandatory2.model.Session;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SessionRepository extends CrudRepository<Session, Integer> {
    List<Session> findAll();
    Session findByUsernameEquals(String username);
}
