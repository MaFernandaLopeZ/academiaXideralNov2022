package com.biblioteca.springboot.cruddemo.dao;

import java.util.List;

import com.biblioteca.springboot.cruddemo.entity.Libro;

public interface LibroDAO {

	List<Libro> findAll();
	
	Libro findById(int theId);
	
	void save(Libro theEmployee);
	
	void deleteById(int theId);
	
}
