package dk.kea.mandatory2.model;

import javax.persistence.*;

@Entity
@Table
@Inheritance( strategy = InheritanceType.JOINED )
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private Integer age;
	private String email;
	private Integer accessLevel;

	public Person() {
	}

	public Person(String name, Integer age, String email, Integer accessLevel) {
		this.name = name;
		this.age = age;
		this.email = email;
		this.accessLevel = accessLevel;
	}

	@Override
	public String toString() {
		return "Person{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				", email='" + email + '\'' +
				", accessLevel=" + accessLevel +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(Integer accessLevel) {
		this.accessLevel = accessLevel;
	}
}
