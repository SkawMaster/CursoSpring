package com.atsistemas.concesionario.interfaces.persistencia;

import java.util.List;

import com.atsistemas.concesionario.entidades.Vehiculo;

public interface VehiculoDao {

	public long save(Vehiculo vehiculo);

	public long delete(long idVehiculo);

	public Vehiculo findOne(long id);

	public List<Vehiculo> findAll();
}
