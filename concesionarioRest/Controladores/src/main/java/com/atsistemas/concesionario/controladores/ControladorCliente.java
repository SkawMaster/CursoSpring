package com.atsistemas.concesionario.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atsistemas.concesionario.entidades.Cliente;
import com.atsistemas.concesionario.interfaces.persistencia.ClienteDao;

@RestController
@RequestMapping(value = ControladorCliente.BASE_URL)
public class ControladorCliente {

	static final String BASE_URL = "/clientes";

	private ClienteDao clienteDao;

	@Autowired
	ControladorCliente(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}

	@RequestMapping(value="/", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public long alta(@RequestBody Cliente cliente) {
		// TODO Auto-generated method stub
		return 0;
	}

	public long baja(long idCliente) {
		// TODO Auto-generated method stub
		return 0;
	}

	public long modificacion(Cliente cliente) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Cliente consultaPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Cliente> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
