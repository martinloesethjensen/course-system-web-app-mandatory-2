package dk.kea.mandatory2.repository;

import dk.kea.mandatory2.model.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
}
