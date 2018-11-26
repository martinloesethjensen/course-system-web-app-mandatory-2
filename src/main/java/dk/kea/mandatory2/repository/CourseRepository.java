package dk.kea.mandatory2.repository;

import dk.kea.mandatory2.model.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Integer> {
    List<Course> findAllByTeachersAndIdIs(Integer id);
}
