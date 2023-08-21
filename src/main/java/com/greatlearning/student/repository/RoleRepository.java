package com.greatlearning.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.student.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}