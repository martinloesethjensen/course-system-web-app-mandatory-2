package dk.kea.mandatory2.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class Teacher extends Person{

	public Teacher() {
	}

	public Teacher(String name, Integer age, String email, Integer accessLevel) {
		super(name, age, email, accessLevel);
	}

	@Override
	public String toString() {
		return "Teacher{" + super.toString() + "}";
	}
}
