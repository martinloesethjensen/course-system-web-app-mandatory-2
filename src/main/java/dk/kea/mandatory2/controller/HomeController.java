package dk.kea.mandatory2.controller;

import dk.kea.mandatory2.model.Course;
import dk.kea.mandatory2.model.Student;
import dk.kea.mandatory2.model.Teacher;
import dk.kea.mandatory2.view.CourseRepository;
import dk.kea.mandatory2.view.StudentRepository;
import dk.kea.mandatory2.view.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

	@Autowired
	TeacherRepository teacherRepository;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	CourseRepository courseRepository;

	@GetMapping("/")
	public String index(){
		Teacher teacher = new Teacher("Hans", 54,1);
		teacherRepository.save(teacher);
		System.out.println(teacher);

		Course course = new Course("Chemistry");

		List<Course> courses = new ArrayList<>();
		courses.add(course);
		courseRepository.save(course);
		Student student = new Student("Helle", 29, 3, courses);

		System.out.println(student);
		studentRepository.save(student);


		return "index";
	}
}
