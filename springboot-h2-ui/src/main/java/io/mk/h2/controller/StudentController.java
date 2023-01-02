package io.mk.h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import io.mk.h2.model.Student;
import io.mk.h2.repo.StudentRepository;

@Controller
public class StudentController {

	@Autowired
	private StudentRepository studentRepo;

	@PostMapping(value = "addStudent")
	public String addStudent(Student student) {
		studentRepo.save(student);
		return ("redirect:/listStudents");
	}

	@GetMapping(value = "addStudent")
	public ModelAndView addStudent1() {
		Student student = new Student();
		return new ModelAndView("newStudent", "form", student);
	}

	@GetMapping(value = "listStudents")
	public ModelAndView getStudents() {
		List<Student> students = studentRepo.findAll();
		return new ModelAndView("listStudentsDet", "students", students);
	}
}
