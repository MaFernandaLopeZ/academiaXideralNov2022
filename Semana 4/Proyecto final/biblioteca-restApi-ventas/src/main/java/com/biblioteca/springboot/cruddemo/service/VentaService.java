package com.biblioteca.springboot.cruddemo.service;

import java.util.List;

import com.biblioteca.springboot.cruddemo.entity.Ventas;

public interface VentaService {

	public List<Ventas> ventaLibro(int theId);
	
}
