package com.atsistemas.concesionario.interfaces.servicios;

import java.util.List;

import com.atsistemas.concesionario.entidades.Vehiculo;

public interface VehiculoServicio {

	public long alta();
	
	public long baja();
	
	public long modificacion();
	
	public Vehiculo consultaPorId(long id);
	
	public List<Vehiculo> consultarTodos();
}
