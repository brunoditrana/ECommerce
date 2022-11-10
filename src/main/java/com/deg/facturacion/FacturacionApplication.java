package com.deg.facturacion;

import com.deg.facturacion.model.Cliente;
import com.deg.facturacion.repository.ClienteRepository;
import com.deg.facturacion.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FacturacionApplication {

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	VentaRepository ventaRepository;

	public static void main(String[] args) {
		SpringApplication.run(FacturacionApplication.class, args);
	}


	public void run(String... arg) throws Exception{

		//Cliente clienteUno = new Cliente();
		//clienteUno.setNombre("Bruno");
		//clienteUno.setApellido("Di Trana");
		//clienteUno.setDni("123123");

		//this.clienteRepository.save(clienteUno);
		//System.out.println("clienteUno = " + clienteUno);
	}

}
