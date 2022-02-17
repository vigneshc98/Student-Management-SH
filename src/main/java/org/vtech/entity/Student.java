package org.vtech.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="studentid")
	private String studentid;
	
	@Column(name="phno")
	private String phno;
	
	@Column(name="place")
	private String place;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	@JoinTable(name="courses_student",
	           joinColumns = @JoinColumn(name="student_id"),
	           inverseJoinColumns = @JoinColumn(name="course_id"))
    List<Courses> theCourses;
	
	@Transient
	private String[] coursesSelected;
	
	public List<Courses> getTheCourses() {
		return theCourses;
	}

	public void setTheCourses(List<Courses> theCourses) {
		this.theCourses = theCourses;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String[] getCoursesSelected() {
		return coursesSelected;
	}

	public void setCoursesSelected(String[] coursesSelected) {
		this.coursesSelected = coursesSelected;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
	
	
	public void addCourse(Courses course) {
		if(theCourses==null) {
			theCourses=new ArrayList<>();
		}
		if(course!=null) {
			theCourses.add(course);
		}
	}
	public void deleteCourse(Courses course) {
		if(theCourses.isEmpty()) {
			System.out.println("IAM EMPTY HERE...");
		}
		else {
			System.out.println("-----In Removingn-------");
			theCourses.remove(course);
		}
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", studentid=" + studentid
				+ ", phno=" + phno + ", place=" + place + ", theCourses=" + theCourses + ", coursesSelected="
				+ Arrays.toString(coursesSelected) + "]";
	}

	
	
}
