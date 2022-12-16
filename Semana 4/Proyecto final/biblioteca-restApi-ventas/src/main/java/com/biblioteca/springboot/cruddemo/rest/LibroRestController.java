package com.biblioteca.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.springboot.cruddemo.entity.Libro;
import com.biblioteca.springboot.cruddemo.entity.Ventas;
import com.biblioteca.springboot.cruddemo.service.LibroService;

@RestController
@RequestMapping("/rest")
public class LibroRestController {

	private LibroService libroService;
	
	@Autowired
	public LibroRestController(LibroService thelibroService) {
		libroService = thelibroService;
	}
	
	// expose "/libros" and return list of libros
	@GetMapping("/libros")
	public List<Libro> findAll() {
		return libroService.findAll();
	}

	// add mapping for GET /libros/{libroId}
	
	@GetMapping("/libros/{libroId}")
	public Libro getLibro(@PathVariable int libroId) throws Exception {
		
		Libro theLibro = libroService.findById(libroId);
		
		if (theLibro == null) {
			throw new Exception("Book id not found - " + libroId);
		}
		
		return theLibro;
	}
	
	// add mapping for POST /libros - add new employee
	
	@PostMapping("/libros")
	public Libro addLibro(@RequestBody Libro theLibro) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theLibro.setId(0);
		
		libroService.save(theLibro);
		
		return theLibro;
	}
	
	// add mapping for PUT /libros - update existing employee
	
	@PutMapping("/libros")
	public Libro updateLibro(@RequestBody Libro theLibro) {
		
		libroService.save(theLibro);
		
		return theLibro;
	}
	
	// add mapping for DELETE /libros/{libroId} - delete employee
	
	@DeleteMapping("/libros/{libroId}")
	public String deleteLibro(@PathVariable int libroId) {
		
		Libro tempLibro = libroService.findById(libroId);
		
		// throw exception if null
		
		if (tempLibro == null) {
			throw new RuntimeException("Book id not found - " + libroId);
		}
		
		libroService.deleteById(libroId);
		
		return "Deleted book id - " + libroId;
	}
	
}










