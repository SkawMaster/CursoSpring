package com.atsistemas.concesionario.interfaces.persistencia;

import java.util.List;

import com.atsistemas.concesionario.entidades.Cliente;

public interface ClienteDao {

	public long save(Cliente cliente);

	public long delete(long idCliente);
	
	public Cliente findOne(long id);

	public List<Cliente> findAll();
}
