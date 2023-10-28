package com.shubham.crud.demo.crudrevi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.shubham.crud.demo.crudrevi.DAO.StudentDAO;
import com.shubham.crud.demo.crudrevi.Entity.Student;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	public CommandLineRunner commandlinerunner(StudentDAO studentDAO)
	{
		return runner->
		{
			
			//create(studentDAO);
			//createMultiple(studentDAO);
			//find(studentDAO);
			//queryForStudents(studentDAO);
			//queryForLastName(studentDAO);
			//update(studentDAO);
			//deleteById(studentDAO);
			deleteALL(studentDAO);
			
		};
	}
	
	private void deleteALL(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		int a=studentDAO.deleteALL();
		System.out.println("All data erased successfully");
		System.out.println(a);
		
	}
	private void deleteById(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		int id=2;
		System.out.println("Deleting the student with id "+id);
		//Student student=studentDAO.findById(id);
		studentDAO.delete(id);
		System.out.println("Deleted Successfully");
		
	}
	private void update(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		int id=3;
		System.out.println("Updating the student with id: "+id);
		Student student=studentDAO.findById(id);
		System.out.println("The earlier data is "+student);
		student.setFirstName("Shubh");
		studentDAO.update(student);
		System.out.println("After updating "+student);
		
	}
	private void queryForLastName(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		List<Student>theStudent=studentDAO.findByLastName("Sharma");
		for(Student temp:theStudent)
		{
			System.out.println(temp);
		}
		
		
	}
	private void queryForStudents(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		List<Student>theStudent=studentDAO.findAll();
		for(Student temp:theStudent)
		{
			System.out.println(temp);
		}
		
	}
	private void find(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		Student temp=new Student("Sagar","Gupta","Sagar@gmail.com");
		System.out.println("Saving the Students");
		studentDAO.save(temp);
		int id=temp.getId();
		System.out.println("Getting the data by ID: "+id);
		Student student=studentDAO.findById(id);
		System.out.println(student);
		
		
	}
	//creating multiple student
	private void createMultiple(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		System.out.println("Creating three Students");
		Student temp1=new Student("Anjali","Sharma","Anjali@gmail.com");
		Student temp2=new Student("Sikha","Sharma","Sikha@gmail.com");
		Student temp3=new Student("Yuvika","Sharma","yuvika@gmail.com");
		// saving the Students to database
		studentDAO.save(temp1);
		studentDAO.save(temp2);
		studentDAO.save(temp3);
		
		System.out.println("Successfully saved the students to the databse");
		
	}
	private void create(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		System.out.println("Creating new Student");
		Student temp=new Student("Shubham","Gupta","shubh@gmail.com");
		studentDAO.save(temp);
		System.out.println("Successfully save the datab to the databse");
		
	}
	
	
	
	

}
