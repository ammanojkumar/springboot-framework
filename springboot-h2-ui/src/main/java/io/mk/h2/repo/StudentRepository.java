package io.mk.h2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import io.mk.h2.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}