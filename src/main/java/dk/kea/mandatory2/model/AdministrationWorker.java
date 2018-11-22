package dk.kea.mandatory2.model;

import javax.persistence.Entity;

@Entity
public class AdministrationWorker extends Person {

	public AdministrationWorker() {
	}

	public AdministrationWorker(String name, Integer age, String email, Integer accessLevel) {
		super(name, age, email, accessLevel);
	}

	@Override
	public String toString() {
		return "AdministrationWorker{" + super.toString() + "}";
	}
}
