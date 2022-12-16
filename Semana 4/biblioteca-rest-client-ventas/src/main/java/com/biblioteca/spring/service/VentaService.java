package com.biblioteca.spring.service;

import java.util.List;

import com.biblioteca.spring.model.Ventas;

public interface VentaService {

	public List<Ventas> getVentas(int theVenta);
	
}
