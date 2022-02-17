package org.vtech.service;

import java.util.List;

import org.vtech.entity.Admins;
import org.vtech.entity.Student;

public interface IstudentService {

	List<Student> getStudent();

	void saveStudent(Student theStudent);

	Student getStudent(int studentId);

	void delete(int studentId);

	List<Student> searchStudent(String theName);

	void addCourse(String[] hold, int studentid);

	void deleteCourse(String[] hold, int studentId);

	String checkAdminAuth(Admins theAdmins);

	String getName(int studentId);



}
