package com.greatlearning.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.student.model.Student;
import com.greatlearning.student.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentContoller {

	@Autowired
	StudentService studentService;

	@GetMapping
	public List<Student> listStudents() {
		return studentService.getStudents();

	}

	@PostMapping
	public Student saveStudent(@RequestBody Student student) {
		return studentService.createStudent(student);

	}

	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable("id") int id) {
		return studentService.updateStudent(id);

	}

	@DeleteMapping("/{id}")
	public void deleteStudentById(@PathVariable("id") int id) {
		studentService.deleteStudent(id);
	}

}
