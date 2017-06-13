package com.atsistemas.concesionario.interfaces.servicios;

import java.util.List;

import com.atsistemas.concesionario.entidades.Vehiculo;

public interface VehiculoServicio {

	/**
	 * Da de alta un vehículo asignando la clave primaria con la secuencia de
	 * BBDD
	 * 
	 * @param vehiculo
	 * @return
	 */
	public long alta(Vehiculo vehiculo);
	
	/**
	 * Elimina de BBDD el vehículo con el identificador idVehiculo
	 * 
	 * @param idVehiculo
	 * @return
	 */
	public long baja(long idVehiculo);
	
	/**
	 * Modifica el vehículo de BBDD con el vehículo pasado por parámetro
	 * 
	 * @param vehiculo
	 * @return
	 */
	public long modificacion(Vehiculo vehiculo);
	
	/**
	 * Devuelve el vehículo con el identificador idVehiculo
	 * 
	 * @param idVehiculo
	 * @return
	 */
	public Vehiculo consultaPorId(long id);
	
	/**
	 * Devuelve una lista de todos los vehículos de la BBDD
	 * 
	 * @return
	 */
	public List<Vehiculo> consultarTodos();
}
