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

	
	public long alta(Vehiculo vehiculo) throws Exception{
		// Como la implementación de save de JpaRepository devuelve un tipo
		// <S extends T> S save(S entity), hay que hacer un cast para
		// devolver lo que queramos, ya que recibiremos por defecto el
		// objeto que insertemos en la tabla destino
		if (vehiculo != null) {
			return ((Vehiculo) vehiculoDao.save(vehiculo)).getId();			
		} else {
			return (0L);
		}
	}

	public long baja(long idVehiculo) {
		if (idVehiculo > 0L) {
			return vehiculoDao.delete(idVehiculo);
		} else
			return (0L);
	}

	public long modificacion(Vehiculo vehiculo) {
		// Como la implementación de save de JpaRepository devuelve un tipo
		// <S extends T> S save(S entity), hay que hacer un cast para
		// devolver lo que queramos, ya que recibiremos por defecto el
		// objeto que insertemos en la tabla destino
		if (vehiculo != null) {
			return ((Vehiculo) vehiculoDao.save(vehiculo)).getId();
		} else {
			return (0l);
		}
	}

	public Vehiculo consultaPorId(long idVehiculo) {
		return vehiculoDao.findOne(idVehiculo);
	}

	public List<Vehiculo> consultarTodos() {
		return vehiculoDao.findAll();
	}

}
