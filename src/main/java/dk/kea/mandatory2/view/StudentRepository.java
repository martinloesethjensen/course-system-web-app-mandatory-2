package dk.kea.mandatory2.view;

import dk.kea.mandatory2.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
