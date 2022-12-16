package com.biblioteca.spring.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.biblioteca.spring.model.Libro;
import com.biblioteca.spring.model.Ventas;

@Service
public class VentaServiceRestClientImpl implements VentaService {

	private RestTemplate restTemplate;

	private String crmRestUrl;
		
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public VentaServiceRestClientImpl(RestTemplate theRestTemplate, 
										@Value("${crm.rest.url_ventas}") String theUrl) {
		
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
		
		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
	}
	
	@Override
	public List<Ventas> getVentas(int theId) {
		
		logger.info("***OBTENER LISTA DE VENTAS DESDE EL SERVICE REST CLIENTE");
		logger.info("in getVentas(): Calling REST API " + crmRestUrl);
		
		// make REST call
		
		ResponseEntity<List<Ventas>> responseEntity = 
											restTemplate.exchange(crmRestUrl + "/" + theId, HttpMethod.GET, null, 
													 new ParameterizedTypeReference<List<Ventas>>() {});
		
		// get the list of libros from response
		List<Ventas> libros = responseEntity.getBody();
		logger.info("in getLibros(): libros" + libros);
		
		return libros;
	}

}
