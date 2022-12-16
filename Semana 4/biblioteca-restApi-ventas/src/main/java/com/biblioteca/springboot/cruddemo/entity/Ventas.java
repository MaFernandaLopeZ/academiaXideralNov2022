package com.biblioteca.springboot.cruddemo.entity;

import javax.persistence.*;
import lombok.*;

@Data 
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="biblioteca")
public class Ventas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="fecha")
	private String fecha;
	
	@Column(name="cantidad")
	private int cantidad;
	
	@Column(name="total")
	private double total;
	
}









