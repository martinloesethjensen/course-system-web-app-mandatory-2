package dk.kea.mandatory2.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String courseNameDanish;
	private String courseNameEnglish;
	private int semester;
	private String classCode;
	@OneToOne
	private StudyProgramme studyProgramme;
	private String mandatoryOrElective;
	private int ects;
	private String courseLanguage;
	private int minNumberOfStudents;
	private int expectedNumberOfStudents;
	private int maxNumberOfStudents;
	private String prerequisites; //something that you need to qualify
	private String learningOutcome;
	private String content;
	private String learningActivities;
	private String examForm;
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "id")
	private List<Teacher> teachers;

	public Course(String courseNameDanish) {
		this.courseNameDanish = courseNameDanish;
	}

	public Course() {
	}

	public Course(String courseNameDanish, String courseNameEnglish, int semester, String classCode, StudyProgramme studyProgramme, String mandatoryOrElective, int ects, String courseLanguage, int minNumberOfStudents, int expectedNumberOfStudents, int maxNumberOfStudents, String prerequisites, String learningOutcome, String content, String learningActivities, String examForm, List<Teacher> teachers) {
		this.courseNameDanish = courseNameDanish;
		this.courseNameEnglish = courseNameEnglish;
		this.semester = semester;
		this.classCode = classCode;
		this.studyProgramme = studyProgramme;
		this.mandatoryOrElective = mandatoryOrElective;
		this.ects = ects;
		this.courseLanguage = courseLanguage;
		this.minNumberOfStudents = minNumberOfStudents;
		this.expectedNumberOfStudents = expectedNumberOfStudents;
		this.maxNumberOfStudents = maxNumberOfStudents;
		this.prerequisites = prerequisites;
		this.learningOutcome = learningOutcome;
		this.content = content;
		this.learningActivities = learningActivities;
		this.examForm = examForm;
		this.teachers = teachers;
	}

	@Override
	public String toString() {
		return "Course{" +
				"id=" + id +
				", courseNameDanish='" + courseNameDanish + '\'' +
				", courseNameEnglish='" + courseNameEnglish + '\'' +
				", semester=" + semester +
				", classCode='" + classCode + '\'' +
				", studyProgramme=" + studyProgramme +
				", mandatoryOrElective='" + mandatoryOrElective + '\'' +
				", ects=" + ects +
				", courseLanguage='" + courseLanguage + '\'' +
				", minNumberOfStudents=" + minNumberOfStudents +
				", expectedNumberOfStudents=" + expectedNumberOfStudents +
				", maxNumberOfStudents=" + maxNumberOfStudents +
				", prerequisites='" + prerequisites + '\'' +
				", learningOutcome='" + learningOutcome + '\'' +
				", content='" + content + '\'' +
				", learningActivities='" + learningActivities + '\'' +
				", examForm='" + examForm + '\'' +
				", teachers=" + teachers +
				'}';
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseNameDanish() {
		return courseNameDanish;
	}

	public void setCourseNameDanish(String courseNameDanish) {
		this.courseNameDanish = courseNameDanish;
	}

	public String getCourseNameEnglish() {
		return courseNameEnglish;
	}

	public void setCourseNameEnglish(String courseNameEnglish) {
		this.courseNameEnglish = courseNameEnglish;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public StudyProgramme getStudyProgramme() {
		return studyProgramme;
	}

	public void setStudyProgramme(StudyProgramme studyProgramme) {
		this.studyProgramme = studyProgramme;
	}

	public String getMandatoryOrElective() {
		return mandatoryOrElective;
	}

	public void setMandatoryOrElective(String mandatoryOrElective) {
		this.mandatoryOrElective = mandatoryOrElective;
	}

	public int getEcts() {
		return ects;
	}

	public void setEcts(int ects) {
		this.ects = ects;
	}

	public String getCourseLanguage() {
		return courseLanguage;
	}

	public void setCourseLanguage(String courseLanguage) {
		this.courseLanguage = courseLanguage;
	}

	public int getMinNumberOfStudents() {
		return minNumberOfStudents;
	}

	public void setMinNumberOfStudents(int minNumberOfStudents) {
		this.minNumberOfStudents = minNumberOfStudents;
	}

	public int getExpectedNumberOfStudents() {
		return expectedNumberOfStudents;
	}

	public void setExpectedNumberOfStudents(int expectedNumberOfStudents) {
		this.expectedNumberOfStudents = expectedNumberOfStudents;
	}

	public int getMaxNumberOfStudents() {
		return maxNumberOfStudents;
	}

	public void setMaxNumberOfStudents(int maxNumberOfStudents) {
		this.maxNumberOfStudents = maxNumberOfStudents;
	}

	public String getPrerequisites() {
		return prerequisites;
	}

	public void setPrerequisites(String prerequisites) {
		this.prerequisites = prerequisites;
	}

	public String getLearningOutcome() {
		return learningOutcome;
	}

	public void setLearningOutcome(String learningOutcome) {
		this.learningOutcome = learningOutcome;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLearningActivities() {
		return learningActivities;
	}

	public void setLearningActivities(String learningActivities) {
		this.learningActivities = learningActivities;
	}

	public String getExamForm() {
		return examForm;
	}

	public void setExamForm(String examForm) {
		this.examForm = examForm;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
}
