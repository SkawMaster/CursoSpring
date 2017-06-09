package com.atsistemas.concesionario.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atsistemas.concesionario.entidades.Vehiculo;
import com.atsistemas.concesionario.interfaces.persistencia.VehiculoDao;
import com.atsistemas.concesionario.interfaces.servicios.VehiculoServicio;

@Service
public class ServicioVehiculo implements VehiculoServicio {

	@Autowired
	private VehiculoDao vehiculoDao;

	public void setVehiculoDao(VehiculoDao vehiculoDao) {
		this.vehiculoDao = vehiculoDao;
	}

	public long alta(Vehiculo vehiculo) {
		return ((Vehiculo) vehiculoDao.save(vehiculo)).getId();
	}

	public long baja(long idVehiculo) {
		return vehiculoDao.delete(idVehiculo);
	}

	public long modificacion(Vehiculo vehiculo) {
		return ((Vehiculo) vehiculoDao.save(vehiculo)).getId();
	}

	public Vehiculo consultaPorId(long id) {
		return vehiculoDao.findOne(id);
	}

	public List<Vehiculo> consultarTodos() {
		return vehiculoDao.findAll();
	}

}
