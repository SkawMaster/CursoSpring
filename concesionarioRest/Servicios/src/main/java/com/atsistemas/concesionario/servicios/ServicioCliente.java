package com.atsistemas.concesionario.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atsistemas.concesionario.entidades.Cliente;
import com.atsistemas.concesionario.interfaces.persistencia.ClienteDao;
import com.atsistemas.concesionario.interfaces.servicios.ClienteServicio;

@Service
public class ServicioCliente implements ClienteServicio {

	@Autowired
	private ClienteDao clienteDao;
	
	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}

	public long alta(Cliente cliente) {
		return ((Cliente)clienteDao.save(cliente)).getId();
	}

	public long baja(long idCliente) {
		return clienteDao.delete(idCliente);
	}

	public long modificacion(Cliente cliente) {
		return ((Cliente)clienteDao.save(cliente)).getId();
	}

	public Cliente consultaPorId(long id) {
		return clienteDao.findOne(id);
	}

	public List<Cliente> consultarTodos() {
		return clienteDao.findAll();
	}	
}
