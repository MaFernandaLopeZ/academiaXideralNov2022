package com.biblioteca.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.biblioteca.spring.model.Libro;
import com.biblioteca.spring.model.Ventas;
import com.biblioteca.spring.service.VentaService;

@Controller
@RequestMapping("/libro")
public class VentaController {

	// need to inject our libro service
	@Autowired
	private VentaService ventaService;
	
	@GetMapping("/listVentas")
	public String listVentas(@RequestParam("libroId") int theId, Model theModel) {
		
		// get libros from the service
		List<Ventas> theVentas = ventaService.getVentas(theId);
				
		// add the libros to the model
		theModel.addAttribute("ventas", theVentas);
		
		return "ventas-form";
	}
}










