package service;

import javax.persistence.*;

import model.Student;

public class StudentTest {

	private static EntityManagerFactory factory;
	private static EntityManager entityManager;
	
	static {
		factory = Persistence.createEntityManagerFactory("JPAMaven");
	}
	
	public static EntityManager getEntityManager() {
		if(entityManager==null || !entityManager.isOpen()) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}
	
	public static void main(String[] args) {
		entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		Student s=new Student();
		s.setStudentId(1);
		s.setName("John");
		
		entityManager.persist(s);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		factory.close();

		System.out.println("added one student..");
	}

}
