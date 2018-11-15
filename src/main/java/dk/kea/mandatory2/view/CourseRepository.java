package dk.kea.mandatory2.view;

import dk.kea.mandatory2.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer> {
}
