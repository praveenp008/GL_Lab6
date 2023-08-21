package com.greatlearning.student.service;

import java.util.List;

import com.greatlearning.student.model.Student;

public interface StudentService {

	Student createStudent(Student student);

	List<Student> getAllStudents();

	Student getStudentById(long id);

	Student updateStudent(Student student, long id);

	void deleteStudent(long id);
}