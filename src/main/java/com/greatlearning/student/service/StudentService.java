package com.greatlearning.student.service;

import java.util.List;

import com.greatlearning.student.model.Student;

public interface StudentService {

	List<Student> getStudents();

	Student createStudent(Student student);

	Student updateStudent(long id);

	void deleteStudent(long id);

}
