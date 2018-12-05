package dk.kea.mandatory2.controller;

import dk.kea.mandatory2.model.StudentCourses;
import dk.kea.mandatory2.repository.CourseRepository;
import dk.kea.mandatory2.repository.StudentCoursesRepository;
import dk.kea.mandatory2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentRESTfulController {
	@Autowired
	CourseRepository courseRepository;

	@Autowired
	StudentCoursesRepository studentCoursesRepository;

	@Autowired
	StudentRepository studentRepository;

	@PostMapping("/student/courses/apply/{course_id}&{user_id}")
	public ResponseEntity<StudentCourses> applyForCourse(@PathVariable("course_id") Integer course_id,
	                                                     @PathVariable("user_id") Integer user_id)
	{
		System.out.println("Course id: " + course_id + "\nUser id: " + user_id);
		StudentCourses studentCourses = new StudentCourses();
		studentCourses.setTime();
		studentCourses.setApproved(0);
		studentCourses.setDenied(0);
		studentCourses.setCourse(courseRepository.getById(course_id));
		studentCourses.getId();
		studentCourses.setStudent(studentRepository.getById(user_id));

		return new ResponseEntity<>(studentCoursesRepository.save(studentCourses), HttpStatus.OK);
	}
}
