package org.vtech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.vtech.entity.Admins;
import org.vtech.entity.Courses;
import org.vtech.entity.Student;
import org.vtech.repository.AdminRepository;
import org.vtech.repository.CourseRepository;
import org.vtech.repository.StudentRepository;

@Component
public class IstudentServiceImpl implements IstudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	@Transactional
	public List<Student> getStudent() {
		return studentRepository.findAll();
	}

	@Override
	@Transactional
	public void saveStudent(Student theStudent) {
		if(theStudent.getId()!=0) {
			int[] arr= courseRepository.getEnrolledCourseId(theStudent.getId());
			for(int i=1; i<=arr.length; i++) {
				Courses theCourses= courseRepository.findById(i);
				theStudent.addCourse(theCourses);
			}
		}
		studentRepository.save(theStudent);
	}

	@Override
	@Transactional
	public Student getStudent(int studentId) {
		return studentRepository.findById(studentId);
	}

	@Override
	@Transactional
	public void delete(int studentId) {
		studentRepository.deleteById(studentId);
	}

	@Override
	@Transactional
	public List<Student> searchStudent(String theName) {
		if(theName=="") {
			return studentRepository.findAll();
		}
		return studentRepository.findByFirstNameOrLastName(theName, theName);
	}

	@Override
	@Transactional
	public void addCourse(String[] hold, int studentid) {
		if(hold.length >0) {
			for(int i=0;i<hold.length;i++) {
				if(hold[i].equals("javafullstack")) {
					List<Object> res = courseRepository.findCoursesStudent(1, studentid);
					if(res.isEmpty()) {
						Student std = studentRepository.findById(studentid);
					    Courses course = courseRepository.findById(1);
						std.addCourse(course);
						studentRepository.save(std);
					}
				}
				if(hold[i].equals("pythonfullstack")) {
					List<Object> res = courseRepository.findCoursesStudent(2, studentid);
					if(res.isEmpty()) {
						Student std = studentRepository.findById(studentid);
						Courses course = courseRepository.findById(2);
						std.addCourse(course);
						studentRepository.save(std);
					}
				}
				if(hold[i].equals("mernstack")) {
					List<Object> res = courseRepository.findCoursesStudent(3, studentid);
					if(res.isEmpty()) {
						Student std = studentRepository.findById(studentid);
						Courses course = courseRepository.findById(3);
						std.addCourse(course);
						studentRepository.save(std);
					}
				}
			}
		}
	}

	@Override
	@Transactional
	public void deleteCourse(String[] hold, int studentId) {
		if(hold.length >0) {
			for(int i=0;i<hold.length;i++) {
				if(hold[i].equals("javafullstack")) {
					List<Object> res = courseRepository.findCoursesStudent(1, studentId);
					if(!res.isEmpty()) {
						Student std = studentRepository.findById(studentId);
					    Courses course = courseRepository.findById(1);
						std.deleteCourse(course);
						studentRepository.save(std);
					}
				}
				if(hold[i].equals("pythonfullstack")) {
					List<Object> res = courseRepository.findCoursesStudent(2, studentId);
					if(!res.isEmpty()) {
						Student std = studentRepository.findById(studentId);
						Courses course = courseRepository.findById(2);
						std.deleteCourse(course);
						studentRepository.save(std);
					}
				}
				if(hold[i].equals("mernstack")) {
					List<Object> res = courseRepository.findCoursesStudent(3, studentId);
					if(!res.isEmpty()) {
						Student std = studentRepository.findById(studentId);
						Courses course = courseRepository.findById(3);
						std.deleteCourse(course);
						studentRepository.save(std);
					}
				}
			}
		}
		
	}

	@Override
	@Transactional
	public String checkAdminAuth(Admins theAdmins) {
		String USERNAME=theAdmins.getName();
		String PASSWORD=theAdmins.getPassword();
		Optional<Admins> admin =  adminRepository.findByNameAndPassword(USERNAME, PASSWORD);
		if(admin.isPresent()) {
			return "authPassed";
		}else {
			return "authFailed";
		}
	}

	@Override
	@Transactional
	public String getName(int studentId) {
		return studentRepository.findName(studentId);
	}


}
