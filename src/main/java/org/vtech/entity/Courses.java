package org.vtech.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="courses")
public class Courses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="course_name")
	private String courseName;
	@Column(name="course_id")
	private String courseId;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name="courses_student", 
	           joinColumns = @JoinColumn(name="course_id"),
	           inverseJoinColumns = @JoinColumn(name="student_id"))
    List<Student> theStudent;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public List<Student> getTheStudent() {
		return theStudent;
	}

	public void setTheStudent(List<Student> theStudent) {
		this.theStudent = theStudent;
	}
	
	public void addStudent(Student student) {
		if(theStudent==null) {
			theStudent = new ArrayList<>();
		}
		if(student!=null) {
			theStudent.add(student);
		}
	}

	@Override
	public String toString() {
		return "Courses [id=" + id + ", courseName=" + courseName + ", courseId=" + courseId + "]";
	}
	
}
