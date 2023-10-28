package com.shubham.crud.demo.crudrevi.DAO;

import java.util.List;

import com.shubham.crud.demo.crudrevi.Entity.Student;

public interface StudentDAO {
	void save(Student theStudent); 
	Student findById(Integer id);
	List<Student>findAll();
	List<Student>findByLastName(String lastName);
	void update(Student theStudent);
	void delete(Integer id);
	int deleteALL();

}
