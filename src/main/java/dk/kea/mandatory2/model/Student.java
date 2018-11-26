package dk.kea.mandatory2.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Student extends Person {

	@ManyToMany
	@JoinColumn(name = "id")
	private List<Course> courses;

	public Student() {
	}

	public Student(String name, Integer age, String email, Session session, List<Course> courses) {
		super(name, age, email, session);
		this.courses = courses;
	}

	@Override
	public String toString() {
		return String.format("courses: %s id: %s name: %s"
				, this.courses, getId(), getName());
	}
}
