package dk.kea.mandatory2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

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
