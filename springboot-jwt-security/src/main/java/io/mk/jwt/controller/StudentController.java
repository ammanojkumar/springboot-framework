package io.mk.jwt.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@RequestMapping("marks/{stuId}")
	public Integer getMarks(@PathVariable Integer stuId) {
		return 97;
	}
}
