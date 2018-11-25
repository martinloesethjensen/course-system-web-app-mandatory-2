package dk.kea.mandatory2.controller;

import dk.kea.mandatory2.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseController {

	@Autowired
	CourseRepository courseRepository;

	@GetMapping("/courses")
	public String listCourses(Model model) {
		model.addAttribute("courses", courseRepository.findAll());
		return "courses";
	}
}
