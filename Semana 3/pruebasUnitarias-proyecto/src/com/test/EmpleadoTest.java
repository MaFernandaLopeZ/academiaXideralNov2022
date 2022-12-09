package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.empleado.salario.*;

class EmpleadoTest {
	
	@DisplayName("Pago quincenal normal")
	@Test
	void test_pagoQuincenal() {
		Empleado esperado = new Empleado("fer", "lopez", "redes", 10000, 10);
		assertEquals(esperado.pago_quincenal(), ((10000.00/30)*10));
	}
	
	@DisplayName("Pago quincenal horas_extras")
	@Test
	void test_pagoQuincenal_extras() {
		Empleado_horasExtra esperado = new Empleado_horasExtra("fer", "lopez", "redes", 10000, 10, 8);
		assertEquals(esperado.pago_quincenal(), (((10000.00/30)/8)* 8));
	}
	
	@DisplayName("Enteros, esperando double, empleado normal")
	@Test
	void test_pagoQuincenal2() {
		Empleado esperado = new Empleado("fer", "lopez", "redes", 10000, 10);
		assertEquals(esperado.pago_quincenal(), ((10000/30)*10));
	}
	
	@DisplayName("Enteros, esperando double, empleado extra")
	@Test
	void test_pagoQuincenal_extras2() {
		Empleado_horasExtra esperado = new Empleado_horasExtra("fer", "lopez", "redes", 10000, 10, 8);
		assertEquals(esperado.pago_quincenal(), (((10000/30)/8)* 8));
	}
	
	@DisplayName("Horas enviadas mayores a las esperadas")
	@Test
	void test_pagoQuincenal_extras3() {
		Empleado_horasExtra esperado = new Empleado_horasExtra("fer", "lopez", "redes", 10000, 10, 8);
		assertEquals(esperado.pago_quincenal(), (((10000/30)/8)* 10));
	}
	
	@DisplayName("Horas enviadas menores a las esperadas, enteros")
	@Test
	void test_pagoQuincenal_extras4() {
		Empleado_horasExtra esperado = new Empleado_horasExtra("fer", "lopez", "redes", 10000, 10, 8);
		assertEquals(esperado.pago_quincenal(), (((10000/30)/8)* 4));
	}
	
	@DisplayName("Saralario mayor al esperado, horas extras, double")
	@Test
	void test_pagoQuincenal_extras5() {
		Empleado_horasExtra esperado = new Empleado_horasExtra("fer", "lopez", "redes", 10000.00, 10, 8);
		Empleado_horasExtra resultado = new Empleado_horasExtra("fer", "lopez", "redes", 15000.00, 10, 8);
		assertEquals(esperado.pago_quincenal(), resultado.pago_quincenal());
	}
	
	@DisplayName("Saralario mayor al esperado, horas extras, int")
	@Test
	void test_pagoQuincenal_extras6() {
		Empleado_horasExtra esperado = new Empleado_horasExtra("fer", "lopez", "redes", 10000, 10, 8);
		Empleado_horasExtra resultado = new Empleado_horasExtra("fer", "lopez", "redes", 15000, 10, 8);
		assertEquals(esperado.pago_quincenal(), resultado.pago_quincenal());
	}
	
	@DisplayName("Saralario menor al esperado, horas extras, double")
	@Test
	void test_pagoQuincenal_extras7() {
		Empleado_horasExtra esperado = new Empleado_horasExtra("fer", "lopez", "redes", 15000.00, 10, 8);
		Empleado_horasExtra resultado = new Empleado_horasExtra("fer", "lopez", "redes", 1000.00, 10, 8);
		assertEquals(esperado.pago_quincenal(), resultado.pago_quincenal());
	}
	
	@DisplayName("Saralario menor al esperado, horas extras, int")
	@Test
	void test_pagoQuincenal_extras8() {
		Empleado_horasExtra esperado = new Empleado_horasExtra("fer", "lopez", "redes", 15000, 15, 8);
		Empleado_horasExtra resultado = new Empleado_horasExtra("fer", "lopez", "redes", 10000, 15, 8);
		assertEquals(esperado.pago_quincenal(), resultado.pago_quincenal());
	}
	
	

}
