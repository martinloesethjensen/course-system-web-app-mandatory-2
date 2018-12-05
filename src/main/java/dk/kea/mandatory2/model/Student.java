package dk.kea.mandatory2.model;

import javax.persistence.Entity;

@Entity
public class Student extends Person {

	public Student() {
	}

	public Student(String name, Integer age, String email, Session session) {
		super(name, age, email, session);
	}

	@Override
	public String toString() {
		return String.format("courses: %s id: %s name: %s", getId(), getName());
	}
}
