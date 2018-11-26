package dk.kea.mandatory2.controller;

import dk.kea.mandatory2.WebSecurityConfig;
import dk.kea.mandatory2.model.Course;
import dk.kea.mandatory2.model.Student;
import dk.kea.mandatory2.model.StudyProgramme;
import dk.kea.mandatory2.model.Teacher;
import dk.kea.mandatory2.repository.CourseRepository;
import dk.kea.mandatory2.repository.StudentRepository;
import dk.kea.mandatory2.repository.StudyProgrammeRepository;
import dk.kea.mandatory2.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	@Autowired
	StudyProgrammeRepository studyProgrammeRepository;

	@GetMapping("/login")
	public String loginView() { return "login"; }

	@GetMapping("/student/")
	public String studentView(Model model) { model.addAttribute("prefix", WebSecurityConfig.getPrefixURL()); return "student/index"; }

	@GetMapping("/teacher/")
	public String teacherView(Model model) { model.addAttribute("prefix", WebSecurityConfig.getPrefixURL()); return "teacher/index"; }

	@GetMapping("/admin/")
	public String adminView(Model model) { model.addAttribute("prefix", WebSecurityConfig.getPrefixURL()); return "admin/index"; }

	@GetMapping("/")
	public String index() {
		Teacher teacher = new Teacher("Santiago Donoso", 54, "sand@kea.dk");
//		teacherRepository.save(teacher);
//		System.out.println(teacher);

		StudyProgramme studyProgramme = new StudyProgramme("Web Development");
//		studyProgrammeRepository.save(studyProgramme);

		List<Teacher> teacherList = new ArrayList<>();

		Course course = new Course(
				"Full Stack NodeJs",
				"Full Stack NodeJs",
				3,
				"WD-2018-F-NODEJS",
				studyProgramme,
				"Elective",
				10,
				"English",
				15,
				35,
				50,
				"Students must know HTML, CSS, JS, PHP and MySQL.",
				"Students will be able to code a full stack web based application, set-up a NODEJS server " +
						"in the cloud and decide the best possible use of MongoDB",
				"NodeJS, Flexbox, Grid, CSS, MongoDB, AJAX, Websockets, JSON objects, Setting up a server " +
						"in Amazon Web Servers and locally. Use of the terminal and FTP. Also, the setup and" +
						" use of HTTPS.",
				"Individual work and exam. Communication takes place via our Ryver " +
				"channel WD-2018-F-NODEJS",
				"Internal oral exam based on hand in product. Graded based on the 7-scale.",
				teacherList
				);

		List<Course> courses = new ArrayList<>();
		courses.add(course);
//		courseRepository.save(course);
		Student student = new Student("Helle", 29, "helle@kea.dk", courses);

//		studentRepository.save(student);

		return "index";
	}
}
