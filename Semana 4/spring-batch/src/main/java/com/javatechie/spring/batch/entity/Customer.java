package com.javatechie.spring.batch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "nombre")
    private String firstName;
    @Column(name = "apellidos")
    private String lastName;
    @Column(name = "correo")
    private String email;
    @Column(name = "genero")
    private String gender;
    @Column(name = "telefono")
    private String contactNo;
    @Column(name = "pais")
    private String country;
    @Column(name = "fecha_nac")
    private String dob;
    
}
