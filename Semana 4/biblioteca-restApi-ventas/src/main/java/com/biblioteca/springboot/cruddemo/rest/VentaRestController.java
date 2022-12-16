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
import com.biblioteca.springboot.cruddemo.service.VentaService;

@RestController
@RequestMapping("/rest")
public class VentaRestController {

	private VentaService ventaService;
	
	@Autowired
	public VentaRestController(VentaService theventaService) {
		ventaService = theventaService;
	}
	
	//	ventas de libro
	@GetMapping("/libros/ventas/{libroId}")
	public List<Ventas> getVentaLibro(@PathVariable int libroId) throws Exception {
		
		return ventaService.ventaLibro(libroId);
		
	}
}










