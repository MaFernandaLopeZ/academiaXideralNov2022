package com.biblioteca.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.biblioteca.springboot.cruddemo.entity.Libro;

@Repository
public class LibroDAOHibernateImpl implements LibroDAO {

	// define field for entitymanager	
	private EntityManager entityManager;
		
	// set up constructor injection
	@Autowired
	public LibroDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Libro> findAll() {
		System.out.println("EmployeeDAOHibernateImpl");
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Libro> theQuery =
				currentSession.createQuery("from Libro", Libro.class);
		
		// execute query and get result list
		List<Libro> libros = theQuery.getResultList();
		
		// return the results		
		return libros;
	}


	@Override
	public Libro findById(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the employee
		Libro theLibro =
				currentSession.get(Libro.class, theId);
		
		// return the employee
		return theLibro;
	}


	@Override
	public void save(Libro theLibro) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save employee
		currentSession.saveOrUpdate(theLibro);
	}


	@Override
	public void deleteById(int theId) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery(
						"delete from Libro where id=:libroId");
		
		theQuery.setParameter("libroId", theId);
		
		theQuery.executeUpdate();
	}

}







