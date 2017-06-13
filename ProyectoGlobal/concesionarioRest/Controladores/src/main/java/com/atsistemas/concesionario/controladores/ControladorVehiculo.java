package com.atsistemas.concesionario.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atsistemas.concesionario.entidades.Vehiculo;
import com.atsistemas.concesionario.interfaces.servicios.VehiculoServicio;

@RestController
@RequestMapping(value = ControladorVehiculo.BASE_URL)
public class ControladorVehiculo {

	static final String BASE_URL = "/vehiculos";

	private VehiculoServicio vehiculoServicio;

	@Autowired
	public ControladorVehiculo(VehiculoServicio vehiculoServicio) {
		this.vehiculoServicio = vehiculoServicio;
	}

	/**
	 * Da de alta un vehículo asignando la clave primaria con la secuencia de
	 * BBDD
	 * 
	 * @param vehiculo
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public long alta(@RequestBody Vehiculo vehiculo) {

		if (vehiculo != null) {
			return vehiculoServicio.alta(vehiculo);
		} else {
			return (0L);
		}
	}

	/**
	 * Elimina de BBDD el vehículo con el identificador idVehiculo
	 * 
	 * @param idVehiculo
	 * @return
	 */
	@RequestMapping(value = "/{idVehiculo}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public long baja(@PathVariable("idVehiculo") long idVehiculo) {

		if (idVehiculo > 0) {
			vehiculoServicio.baja(idVehiculo);
			return idVehiculo;
		} else
			return 0L;
	}

	/**
	 * Modifica el vehículo de BBDD con el vehículo pasado por parámetro
	 * 
	 * @param vehiculo
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public long modificacion(@RequestBody Vehiculo vehiculo) {

		if (vehiculo != null) {
			return vehiculoServicio.modificacion(vehiculo);
		} else {
			return 0L;
		}
	}

	/**
	 * Devuelve el vehículo con el identificador idVehiculo
	 * 
	 * @param idVehiculo
	 * @return
	 */
	@RequestMapping(value = "/{idVehiculo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Vehiculo consultaPorId(@PathVariable("idVehiculo") long idVehiculo) {

		Vehiculo vehiculoRecuperado;
		vehiculoRecuperado = vehiculoServicio.consultaPorId(idVehiculo);

		return vehiculoRecuperado;
	}

	/**
	 * Devuelve una lista de todos los vehículos de la BBDD
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Vehiculo> consultarTodos() {

		List<Vehiculo> listaRecuperada;
		listaRecuperada = vehiculoServicio.consultarTodos();

		return listaRecuperada;
	}
}
