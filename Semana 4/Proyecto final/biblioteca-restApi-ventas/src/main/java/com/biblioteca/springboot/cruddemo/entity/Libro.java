package com.biblioteca.springboot.cruddemo.entity;

import javax.persistence.*;
import lombok.*;

@Data 
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="biblioteca")
public class Libro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre_libro")
	private String nombre;
	
	@Column(name="genero")
	private String genero;
	
	@Column(name="auto")
	private String autor;
	
	@Column(name="precio")
	private double precio;
	
}









