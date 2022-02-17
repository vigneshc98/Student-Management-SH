package org.vtech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.vtech.entity.Admins;
import org.vtech.entity.Student;
import org.vtech.repository.AdminRepository;
import org.vtech.service.IstudentService;

@Controller
@RequestMapping("/studentController")
public class StudentController {
	
	@Autowired
	private IstudentService studentService;
	
//	@Autowired
//	private AdminRepository adminRepo;
//	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/welcomelist")
	public String welcomeListStudent(Model model){	
		List<Student> theStudent = studentService.getStudent();	
		System.out.println("THE STUDENT:"+theStudent);
		model.addAttribute("student",theStudent);
		
		
//		Admins admin = new Admins();
//		admin.setName("admin");
//		admin.setPassword(passwordEncoder.encode("admin"));
//		adminRepo.save(admin);
//		System.out.println("SUCCESS ......");
		
		return "welcome";
	}
	
	@PostMapping("/searchWelcomeStudent")
	public String searchWelcomeStudent(@RequestParam("searchStudentName")String theName, Model theModel) {
		List<Student> theStudent = studentService.searchStudent(theName);
		theModel.addAttribute("student", theStudent);
		return "welcome";
	}
	
	@GetMapping("/adminAuth")
	public String adminAuth(Model theModel) {
		theModel.addAttribute("admins",new Admins());
		return "admin-auth";
	}
	
	@GetMapping("/adminAuth/goterror")
	public String checkAdminAuth(@ModelAttribute("admins")Admins theAdmins, Model theModel) {
		
//		String result = studentService.checkAdminAuth(theAdmins);
		
//		System.out.println("RESULT:"+result);
				
//		if(result=="authPassed") {
//			return "redirect:/studentController/list";
//		}
//		else {
			theModel.addAttribute("errorMsg","Invalid username or password...!");
			return "admin-auth";	
//		}
	}
	
	@GetMapping("/list")
	public String listStudent(Model model){
		
		Iterable<Student> theStudent = studentService.getStudent();
		
//		List course=  (List) theStudent.get(0);
		
//		System.out.println(theStudent);
		
//		List<Object> coursesTook  = studentService.coursesTook(theStudent);
		
		model.addAttribute("student",theStudent);
		
		return "student-list";
	}
	
	@GetMapping("/addStudentForm")
	public String addStudent(Model model) {
		model.addAttribute("student",new Student());
		model.addAttribute("taskName", "Add");
		return "add-student-form";
	}
	
	@PostMapping("/addStudent")
	public String addStudent(@ModelAttribute("student") Student theStudent) {
		
		studentService.saveStudent(theStudent);
		
		return "redirect:/studentController/list";
	}
	
	@GetMapping("/updateStudent")
	public String updateStudent(@RequestParam("studentId") int studentId, Model model){
//		System.out.println("id:"+studentId);
		Student theStudent= studentService.getStudent(studentId);
		
		String name= studentService.getName(studentId);
		
		model.addAttribute("student", theStudent);	
		model.addAttribute("taskName", "Update");
		model.addAttribute("studentName", name);
		return "add-student-form";
	}
	
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("studentId")int studentId) {
//		System.out.println("id:"+studentId);
		studentService.delete(studentId);
		return "redirect:/studentController/list";
	}
	
	@GetMapping("/searchStudent")
	public String searchStudent(@RequestParam("searchStudentName")String theName, Model theModel) {
		
//		System.out.println("theName:"+theName);
		
		List<Student> theStudent = studentService.searchStudent(theName);
		
		theModel.addAttribute("student", theStudent);
		
		return "student-list";
	}
	
	@GetMapping("addCourseForm")
	public String addCourseForm(@RequestParam("studentid")int studentId,  Model model) {
		model.addAttribute("taskName", "Add");
		model.addAttribute("studentid",studentId);
		model.addAttribute("student", new Student());
		
		String name= studentService.getName(studentId);
		model.addAttribute("studentName", name);

		return "add-course";
	}
	
	@PostMapping("/addCourse")
	public String addCourse(@ModelAttribute("student") Student theStudent, Model theModel) {

		String[] hold = theStudent.getCoursesSelected();
		int studentid= theStudent.getId();
		studentService.addCourse(hold, studentid);
		return "redirect:/studentController/list";
	}
	
	@GetMapping("/deleteCourseForm")
	public String deleteCourseForm(@RequestParam("studentid")int studentId,  Model model) {
		model.addAttribute("taskName", "Delete");
		model.addAttribute("studentid",studentId);
		model.addAttribute("student", new Student());
		
		String name= studentService.getName(studentId);
		model.addAttribute("studentName", name);
		
		return "add-course";
	}
	@PostMapping("/deleteCourse")
	public String deleteCourse(@ModelAttribute("student") Student theStudent, Model theModel) {
		String[] hold = theStudent.getCoursesSelected();
		int studentId = theStudent.getId();
		studentService.deleteCourse(hold, studentId);
		return "redirect:/studentController/list";
		
	}
	

}
