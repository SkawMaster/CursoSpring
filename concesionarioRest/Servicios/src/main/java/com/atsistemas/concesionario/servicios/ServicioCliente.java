package com.atsistemas.concesionario.servicios;

import java.util.List;

import com.atsistemas.concesionario.entidades.Cliente;
import com.atsistemas.concesionario.interfaces.persistencia.ClienteDao;
import com.atsistemas.concesionario.interfaces.servicios.ClienteServicio;

public class ServicioCliente implements ClienteServicio {

	private ClienteDao clienteDao;

	public long alta(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	public long baja(long idCliente) {
		return clienteDao.delete(idCliente);
	}

	public long modificacion(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	public Cliente consultaPorId(long id) {
		return clienteDao.findOne(id);
	}

	public List<Cliente> consultarTodos() {
		return clienteDao.findAll();
	}

	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}

}
