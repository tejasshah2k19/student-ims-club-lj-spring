package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.StudentBean;
import com.dao.StudentDao;

@Controller
public class StudentController {

	@Autowired
	StudentDao studentDao;// instance

	@GetMapping("/newstudent")
	public String newStudent() {
		return "NewStudent";// jsp name
	}

	@PostMapping("/savestudent")
	public String saveStudent(StudentBean studentBean) {
		studentDao.addStudent(studentBean);
		return "NewStudent";// jsp name
	}

	@GetMapping("/liststudents")
	public String listStudents(Model model) {
		List<StudentBean> students = studentDao.getAllStudents();
		model.addAttribute("students", students);//
		return "ListStudent";// jsp name
	}

	// search -> name

	@GetMapping("/deletestudent")
	public String deleteStudent(StudentBean studentBean) {

		studentDao.deleteStudentById(studentBean.getStudentId());	
		// select * from students
		return "redirect:/liststudents";// open another url

		// return "ListStudent";
	}

}
