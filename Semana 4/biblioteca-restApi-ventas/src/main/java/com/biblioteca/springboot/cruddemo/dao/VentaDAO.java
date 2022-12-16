package com.biblioteca.springboot.cruddemo.dao;

import java.util.List;

import com.biblioteca.springboot.cruddemo.entity.Ventas;

public interface VentaDAO {

	List<Ventas> ventaLibro(int theId);
	
}
