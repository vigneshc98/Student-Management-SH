package org.vtech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.vtech.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByFirstNameOrLastName(String firstName, String lastName);

	Student findById(int id);

	@Query("select s.firstName from Student s where s.id=:ID")
	String findName(@Param("ID") int ID);
}
