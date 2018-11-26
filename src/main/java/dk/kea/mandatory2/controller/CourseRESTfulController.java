package dk.kea.mandatory2.controller;

import dk.kea.mandatory2.model.Course;
import dk.kea.mandatory2.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseRESTfulController {

	@Autowired
	CourseRepository courseRepository;

	@DeleteMapping("/course/delete/{id}")
	public ResponseEntity deleteCourse(@PathVariable("id") Integer id) {
		if (!courseRepository.existsById(id)) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		courseRepository.deleteById(id);
		return new ResponseEntity<>("Deleted course", HttpStatus.OK);
	}

	@PostMapping("course/create")
	public ResponseEntity createCourse(Course course) {
		if(course == null)
			return new ResponseEntity<>("WHAT! No course detected", HttpStatus.NO_CONTENT);
		courseRepository.save(course);
		CourseController.success = true;
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}
}
