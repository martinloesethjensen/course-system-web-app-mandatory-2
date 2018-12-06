package dk.kea.mandatory2.controller;

import dk.kea.mandatory2.WebSecurityConfig;
import dk.kea.mandatory2.model.Course;
import dk.kea.mandatory2.repository.CourseRepository;
import dk.kea.mandatory2.repository.StudentCoursesRepository;
import dk.kea.mandatory2.repository.StudyProgrammeRepository;
import dk.kea.mandatory2.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

	@Autowired
	StudentCoursesRepository studentCoursesRepository;

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

	@GetMapping("/student/courses/")
	public String listCoursesForStudent(Model model,
	                                    @RequestParam(defaultValue = "", name = "search") String search)
	{
		List<Course> courses = null;

		int userId = WebSecurityConfig.getMyId();
		model.addAttribute("user_id", userId);
		model.addAttribute("prefix", WebSecurityConfig.getPrefixURL());
		if (search.equals("")) {
			courses = courseRepository.findAllById(userId);
		} else {
			courses = courseRepository.findCoursesByCourseNameDanishContaining(search);
		}
		model.addAttribute("courses", courses);
		return "student/courseList";
	}
}
