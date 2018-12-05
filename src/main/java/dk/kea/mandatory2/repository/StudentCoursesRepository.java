package dk.kea.mandatory2.repository;

import dk.kea.mandatory2.model.StudentCourses;
import org.springframework.data.repository.CrudRepository;

public interface StudentCoursesRepository extends CrudRepository<StudentCourses, Long> {
}
