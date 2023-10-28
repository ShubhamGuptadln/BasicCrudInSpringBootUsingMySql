package com.shubham.crud.demo.crudrevi.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shubham.crud.demo.crudrevi.Entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImplement implements StudentDAO {
	
	private EntityManager entityManager;
	public StudentDAOImplement(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	@Override
	@Transactional
	public void save(Student theStudent) {
		// TODO Auto-generated method stub
		entityManager.persist(theStudent);
		
		
	}
	@Override
	public Student findById(Integer id) {
		// TODO Auto-generated method stub
		Student student=entityManager.find(Student.class, id);
		return student;
	}
	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		TypedQuery<Student>theQuery=entityManager.createQuery("From Student order by lastName ",Student.class);
		return theQuery.getResultList();
		
	}
	@Override
	public List<Student> findByLastName(String lastName ) {
		// TODO Auto-generated method stub
		TypedQuery<Student>theQuery=entityManager.createQuery("From Student where lastName=:theData ",Student.class);
		theQuery.setParameter("theData", lastName);
		
		return theQuery.getResultList();
	}
	@Override
	@Transactional
	public void update(Student theStudent) {
		// TODO Auto-generated method stub
		entityManager.merge(theStudent);
		
		
	}
	@Override
	@Transactional
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Student student=entityManager.find(Student.class, id);
		entityManager.remove(student);
		
		
	}
	@Override
	@Transactional
	public int deleteALL() {
		// TODO Auto-generated method stub
		int numberofRows=entityManager.createQuery("DELETE From Student").executeUpdate();
		return numberofRows;
		
	}
		

	
	

	

}
