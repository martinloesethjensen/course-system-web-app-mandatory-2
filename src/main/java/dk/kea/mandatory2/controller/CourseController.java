package dk.kea.mandatory2.controller;

import dk.kea.mandatory2.WebSecurityConfig;
import dk.kea.mandatory2.model.Course;
import dk.kea.mandatory2.repository.CourseRepository;
import dk.kea.mandatory2.repository.StudyProgrammeRepository;
import dk.kea.mandatory2.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CourseController {
    public static boolean success = false;
    public static boolean failed = false;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	StudyProgrammeRepository studyProgrammeRepository;

	@Autowired
	TeacherRepository teacherRepository;

//	@GetMapping("/courses")
//	public String listCourses(Model model) {
//		model.addAttribute("prefix", WebSecurityConfig.getPrefixURL());
//		model.addAttribute("courses", courseRepository.findAll());
//		return "courses";
//	}

	@GetMapping("/teacher/courses/")
	public String listCoursesTeacher(Model model) {
		model.addAttribute("prefix", WebSecurityConfig.getPrefixURL());
		model.addAttribute("courses", courseRepository.findAllByTeachers_idOrderByIdAsc(WebSecurityConfig.getMyId()));
		model.addAttribute("success", success);
		success = false;
		return "teacher/courseList";
	}

	@GetMapping("/teacher/courses/create")
	public String createCourse(Model model) {
		model.addAttribute("prefix", WebSecurityConfig.getPrefixURL());
		model.addAttribute("course", new Course());
		model.addAttribute("studyProgrammes", studyProgrammeRepository.findAll());
		model.addAttribute("teachers", teacherRepository.findAll());
		return "teacher/courseCreate";
	}

	@GetMapping("/teacher/courses/edit/{id}")
    public String createCourse(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("prefix", WebSecurityConfig.getPrefixURL());
        model.addAttribute("course", courseRepository.findAllById(id));
        model.addAttribute("studyProgrammes", studyProgrammeRepository.findAll());
        model.addAttribute("teachers", teacherRepository.findAll());
        return "teacher/courseEdit";
    }

	@GetMapping("/student/courses")
	public String listCoursesForStudent(Model model) {
		model.addAttribute("prefix", WebSecurityConfig.getPrefixURL());
		model.addAttribute("courses", courseRepository.findAllById(WebSecurityConfig.getMyId()));
		return "student/courseList";
	}
}
