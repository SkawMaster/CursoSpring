package com.atsistemas.concesionario.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atsistemas.concesionario.entidades.Cliente;
import com.atsistemas.concesionario.interfaces.servicios.ClienteServicio;

@RestController
@RequestMapping(value = ControladorCliente.BASE_URL)
public class ControladorCliente {

	static final String BASE_URL = "/clientes";

	private ClienteServicio clienteServicio;

	@Autowired
	ControladorCliente(ClienteServicio clienteServicio) {
		this.clienteServicio = clienteServicio;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public long alta(@RequestBody Cliente cliente) {
		if (cliente != null) {
			return clienteServicio.alta(cliente);
		} else {
			return 0L;
		}
	}

	@RequestMapping(value = "/{idCliente}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public long baja(@PathVariable("idCliente") long idCliente) {
		if (idCliente > 0) {
			return clienteServicio.baja(idCliente);
		}
		return 0L;
	}

	@RequestMapping(value = "/", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public long modificacion(@RequestBody Cliente cliente) {
		// Como la implementación de save de JpaRepository devuelve un tipo
		// <S extends T> S save(S entity), hay que hacer un cast para
		// devolver lo que queramos, ya que recibiremos por defecto el
		// objeto que insertemos en la tabla destino
		if (cliente != null) {
			return clienteServicio.modificacion(cliente);
		} else {
			return 0L;
		}
	}

	@RequestMapping(value = "/{idCliente}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Cliente consultaPorId(@PathVariable("idCliente") long idCliente) {
		if (idCliente > 0) { 
			return clienteServicio.consultaPorId(idCliente);
		} else {
			return new Cliente();
		}
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Cliente> consultarTodos() {
		List<Cliente> listaClientes;
		
		listaClientes = clienteServicio.consultarTodos();
		
		return listaClientes;
	}

}
