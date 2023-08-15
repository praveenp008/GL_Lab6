package com.greatlearning.student.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.student.model.Student;
import com.greatlearning.student.repository.StudentJpaRespository;
import com.greatlearning.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentJpaRespository studentRepository;

	@Override
	public List<Student> getStudents() {
		List<Student> students = studentRepository.findAll();
		return students;

	}

	@Override
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(long id) {
		Optional<Student> studentOne = studentRepository.findById((int) id);
		if (studentOne.isPresent()) {
			Student stud = studentOne.get();
			stud.setFirstName(stud.getFirstName());
			stud.setLastName(stud.getLastName());
			stud.setCourse(stud.getCourse());
			stud.setCountry(stud.getCountry());
			return studentRepository.save(stud);
		}

		throw new IllegalArgumentException("Invalid id passed");
	}

	@Override
	public void deleteStudent(long id) {
		studentRepository.deleteById((int) id);

	}

}
