package manytomanybim2.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomanybim2.dto.Courses;
import manytomanybim2.dto.Student;

public class StudentCoursesCont {
public static void main(String[] args) {
	Courses courses1=new Courses();
	courses1.setId(1);
	courses1.setName("java");
	courses1.setFees(500);
	
	Courses courses2=new Courses();
	courses2.setId(2);
	courses2.setName("advjava");
	courses2.setFees(500);
	
	
	Courses courses3=new Courses();
	courses3.setId(3);
	courses3.setName("sql");
	courses3.setFees(500);
	
	
	Student student1=new Student();
	student1.setId(1);
	student1.setName("poojitha");
	student1.setAddress("bangalore");
	
	List<Courses> coursesofpoo=new ArrayList<Courses>();
	coursesofpoo.add(courses1);
	coursesofpoo.add(courses2);
	coursesofpoo.add(courses3);
	
	
	student1.setCourses(coursesofpoo);
	
	Student student2=new Student();
	student2.setId(2);
	student2.setName("vijay");
	student2.setAddress("bangalore");
	
	student2.setCourses(coursesofpoo);
	
	List<Student> students=new ArrayList<Student>();
	students.add(student1);
	students.add(student2);
	
	courses1.setStudents(students);
	courses2.setStudents(students);
	courses3.setStudents(students);
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(courses1);
	entityManager.persist(courses2);
	entityManager.persist(courses3);
	entityManager.persist(student1);	
	entityManager.persist(student2);
	entityTransaction.commit();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
