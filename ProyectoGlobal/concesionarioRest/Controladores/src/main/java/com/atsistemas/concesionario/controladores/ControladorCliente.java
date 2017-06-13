package com.atsistemas.concesionario.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	/**
	 * Da de alta un cliente asignando la clave primaria con la secuencia de
	 * BBDD
	 * 
	 * @param cliente
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public long alta(@RequestBody Cliente cliente) {
		if (cliente != null) {
			return clienteServicio.alta(cliente);
		} else {
			return 0L;
		}
	}

	/**
	 * Elimina de BBDD el cliente con el identificador idCliente
	 * 
	 * @param idCliente
	 * @return
	 */
	@RequestMapping(value = "/{idCliente}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public long baja(@PathVariable("idCliente") long idCliente) {
		if (idCliente > 0) {
			return clienteServicio.baja(idCliente);
		}
		return 0L;
	}

	/**
	 * Modifica el cliente de BBDD con el cliente pasado por parámetro
	 * 
	 * @param cliente
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public long modificacion(@RequestBody Cliente cliente) {
		if (cliente != null) {
			return clienteServicio.modificacion(cliente);
		} else {
			return 0L;
		}
	}

	/**
	 * Devuelve el cliente con el identificador idCliente
	 * 
	 * @param idCliente
	 * @return
	 */
	@RequestMapping(value = "/{idCliente}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Cliente consultaPorId(@PathVariable("idCliente") long idCliente) {
		if (idCliente > 0) { 
			return clienteServicio.consultaPorId(idCliente);
		} else {
			return new Cliente();
		}
	}

	/**
	 * Devuelve una lista de todos los clientes de la BBDD
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Cliente> consultarTodos() {
		List<Cliente> listaClientes;
		
		listaClientes = clienteServicio.consultarTodos();
		
		return listaClientes;
	}

}
