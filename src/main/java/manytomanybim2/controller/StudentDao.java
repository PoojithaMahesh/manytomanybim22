package manytomanybim2.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomanybim2.dto.Courses;
import manytomanybim2.dto.Student;

public class StudentDao {

	public void deleteStudentById(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Student student=entityManager.find(Student.class, id);
		
		if(student!=null) {
		entityTransaction.begin();
		entityManager.remove(student);
		entityTransaction.commit();
		}else {
			System.out.println("id is not present");
		}
	}
	
	
	public void deleteCoursesById(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Courses courses =entityManager.find(Courses.class, id);
		
		if(courses!=null) {
		entityTransaction.begin();
		List<Student> students=courses.getStudents();
		for(Student student:students) {
			List<Courses> listofcourses=student.getCourses();
			listofcourses.remove(courses);
		}
		entityManager.remove(courses);
		entityTransaction.commit();
		}else {
			System.out.println("id is not present");
		}
	}
}
