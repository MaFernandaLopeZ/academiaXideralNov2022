package com.biblioteca.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.biblioteca.springboot.cruddemo.dao.VentaDAO;
import com.biblioteca.springboot.cruddemo.entity.Ventas;

@Service
public class VentaServiceImpl implements VentaService {

	
	private VentaDAO ventaDAO;
	
	@Autowired
	public VentaServiceImpl(@Qualifier("ventaDAOJdbcImpl") VentaDAO theventaDAO) {
		ventaDAO = theventaDAO;
	}
	
	@Override
	@Transactional
	public List<Ventas> ventaLibro(int theId) {
		return ventaDAO.ventaLibro(theId);
	}

}






