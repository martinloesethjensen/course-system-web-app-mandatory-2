package dk.kea.mandatory2.model;

import javax.persistence.Entity;

@Entity
public class Teacher extends Person{

	public Teacher() {
	}

	public Teacher(String name, Integer age, String email, Session session) {
		super(name, age, email, session);
	}

	@Override
	public String toString() {
		return "Teacher{" + super.toString() + "}";
	}
}
