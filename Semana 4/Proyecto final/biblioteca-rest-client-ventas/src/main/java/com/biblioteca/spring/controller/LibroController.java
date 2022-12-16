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
import com.biblioteca.spring.service.LibroService;

@Controller
@RequestMapping("/libro")
public class LibroController {

	// need to inject our libro service
	@Autowired
	private LibroService libroService;
	
	@GetMapping("/list")
	public String listLibros(Model theModel) {
		
		// get libros from the service
		List<Libro> theLibros = libroService.getLibros();
				
		// add the libros to the model
		theModel.addAttribute("libros", theLibros);
		
		return "list-libros";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Libro theLibro = new Libro();
		
		theModel.addAttribute("libro", theLibro);
		
		return "libro-form";
	}
	
	@PostMapping("/saveLibro")
	public String saveLibro(@ModelAttribute("libro") Libro theLibro) {
		
		// save the libro using our service
		libroService.saveLibro(theLibro);	
		
		return "redirect:/libro/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("libroId") int theId,
									Model theModel) {
		
		// get the libro from our service
		Libro theLibro = libroService.getLibro(theId);
		
		// set libro as a model attribute to pre-populate the form
		theModel.addAttribute("libro", theLibro);
		
		// send over to our form		
		return "libro-form";
	}
	
	@GetMapping("/delete")
	public String deleteLibro(@RequestParam("libroId") int theId) {
		
		// delete the libro
		libroService.deleteLibro(theId);
		
		return "redirect:/libro/list";
	}
}










