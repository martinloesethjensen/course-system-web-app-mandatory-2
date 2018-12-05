package dk.kea.mandatory2.model;

import javax.persistence.*;

@Entity
@Table(name = "STUDENT_COURSES")
public class StudentCourses {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id")
	private Student student;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id")
	private Course course;

    private int approved;
    private int denied;
    private long time;

    public StudentCourses() {
    }

    public StudentCourses(long id, Student student, Course course, int approved, int denied, long time) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.approved = approved;
        this.denied = denied;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getApproved() {
        return approved;
    }

    public void setApproved(int approved) {
        this.approved = approved;
    }

    public int getDenied() {
        return denied;
    }

    public void setDenied(int denied) {
        this.denied = denied;
    }

    public long getTime() {
        return time;
    }

    public void setTime() {
        this.time = System.currentTimeMillis() / 1000;
    }
}
