package com.atsistemas.concesionario.interfaces.servicios;

import java.util.List;

import com.atsistemas.concesionario.entidades.Cliente;

public interface ClienteServicio {

	public long alta(Cliente cliente);
	
	public long baja(long idCliente);
	
	public long modificacion(Cliente cliente);
	
	public Cliente consultaPorId(long id);
	
	public List<Cliente> consultarTodos();
}
