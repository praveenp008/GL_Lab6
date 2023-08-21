package com.greatlearning.student.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.student.model.Student;
import com.greatlearning.student.repository.StudentRespository;
import com.greatlearning.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRespository studentRepo;

	@Override
	public Student createStudent(Student student) {
		return this.studentRepo.save(student);
	}

	@Override
	public List<Student> getAllStudents() {

		return this.studentRepo.findAll();
	}

	@Override
	public Student getStudentById(long id) {
		return this.studentRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Student Id passed."));
	}

	@Override
	public Student updateStudent(Student student, long id) {
		Student currentStudents = this.studentRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Student Id passed."));
		if (currentStudents != null) {
			currentStudents.setFirstName(student.getFirstName());
			currentStudents.setLastName(student.getLastName());
			currentStudents.setCourse(student.getCourse());
			currentStudents.setCountry(student.getCountry());

			return this.studentRepo.save(currentStudents);
		}
		return null;
	}

	@Override
	public void deleteStudent(long id) {
		this.studentRepo.deleteById(id);
	}

}
