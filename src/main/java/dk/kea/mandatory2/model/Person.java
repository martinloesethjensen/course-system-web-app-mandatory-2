package dk.kea.mandatory2.model;

import javax.persistence.*;

@Entity
@Table
@Inheritance( strategy = InheritanceType.JOINED )
public abstract class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private Integer age;
	private String email;
	@OneToOne
	private Session session;

	public Person() {
	}

	public Person(String name, Integer age, String email, Session session) {
		this.name = name;
		this.age = age;
		this.email = email;
		this.session = session;
	}

	@Override
	public String toString() {
		return "Person{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				", email='" + email + '\'' +
				", session=" + session +
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
}
