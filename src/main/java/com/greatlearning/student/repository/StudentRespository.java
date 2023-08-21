package com.greatlearning.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.student.model.Student;

@Repository
public interface StudentRespository extends JpaRepository<Student, Long> {

}