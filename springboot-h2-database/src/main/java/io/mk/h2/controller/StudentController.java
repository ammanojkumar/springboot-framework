package io.mk.h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import io.mk.h2.model.Student;
import io.mk.h2.repo.StudentRepository;

@Controller
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@RequestMapping(value = "addStudent", method = RequestMethod.POST)
	public String newEmployee(Student student) {
		studentRepository.save(student);
		return ("redirect:/listStudents");
	}

	@RequestMapping(value = "addStudent", method = RequestMethod.GET)
	public ModelAndView addNewEmployee() {
		Student student = new Student();
		return new ModelAndView("newStudent", "form", student);

	}

	@RequestMapping(value = "listStudents", method = RequestMethod.GET)
	public ModelAndView students() {
		List<Student> students = studentRepository.findAll();
		return new ModelAndView("listStudentsDet", "students", students);
	}
}
