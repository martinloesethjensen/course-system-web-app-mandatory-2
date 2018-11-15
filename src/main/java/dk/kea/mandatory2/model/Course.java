package dk.kea.mandatory2.model;

import java.util.List;

public class Course {
	private String courseNameDanish;
	private String courseNameEnglish;
	private int semester;
	private String classCode;
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
	private List<Teacher> teachers;
}
