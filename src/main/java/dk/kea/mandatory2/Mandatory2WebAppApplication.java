package dk.kea.mandatory2;

import dk.kea.mandatory2.model.Person;
import dk.kea.mandatory2.model.StudyProgramme;
import dk.kea.mandatory2.model.Teacher;
import dk.kea.mandatory2.view.StudyProgrammeRepository;
import dk.kea.mandatory2.view.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.repository.CrudRepository;

import java.awt.*;

@SpringBootApplication
public class Mandatory2WebAppApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Mandatory2WebAppApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Mandatory2WebAppApplication.class, args);
	}
}
