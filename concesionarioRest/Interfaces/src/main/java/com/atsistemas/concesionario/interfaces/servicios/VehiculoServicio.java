package com.atsistemas.concesionario.interfaces.servicios;

import java.util.List;

import com.atsistemas.concesionario.entidades.Vehiculo;

public interface VehiculoServicio {

	public long alta(Vehiculo vehiculo);
	
	public long baja(long idVehiculo);
	
	public long modificacion(Vehiculo vehiculo);
	
	public Vehiculo consultaPorId(long id);
	
	public List<Vehiculo> consultarTodos();
}
