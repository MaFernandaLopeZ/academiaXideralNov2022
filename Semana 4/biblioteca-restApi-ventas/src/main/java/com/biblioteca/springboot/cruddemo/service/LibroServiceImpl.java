package com.biblioteca.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.biblioteca.springboot.cruddemo.dao.LibroDAO;
import com.biblioteca.springboot.cruddemo.entity.Libro;

@Service
public class LibroServiceImpl implements LibroService {

	
	private LibroDAO libroDAO;
	
	@Autowired
	public LibroServiceImpl(@Qualifier("libroDAOJdbcImpl") LibroDAO thelibroDAO) {
		libroDAO = thelibroDAO;
	}
	
	@Override
	@Transactional
	public List<Libro> findAll() {
		return libroDAO.findAll();
	}

	@Override
	@Transactional
	public Libro findById(int theId) {
		return libroDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Libro theLibro) {
		libroDAO.save(theLibro);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		libroDAO.deleteById(theId);
	}

}






