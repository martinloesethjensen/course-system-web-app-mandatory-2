package dk.kea.mandatory2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudyProgramme {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String programme;

	public StudyProgramme() {
	}

	public StudyProgramme(String programme) {
		this.programme = programme;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProgramme() {
		return programme;
	}

	public void setProgramme(String programme) {
		this.programme = programme;
	}

	@Override
	public String toString() {
		return "StudyProgramme{" +
				"id=" + id +
				", programme='" + programme + '\'' +
				'}';
	}
}
