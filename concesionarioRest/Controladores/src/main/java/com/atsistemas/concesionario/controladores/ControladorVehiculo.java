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
import com.atsistemas.concesionario.interfaces.persistencia.VehiculoDao;
import com.atsistemas.concesionario.servicios.ServicioVehiculo;

@RestController
@RequestMapping(value = ControladorVehiculo.BASE_URL)
public class ControladorVehiculo {

	static final String BASE_URL = "/vehiculos";

	private ServicioVehiculo servicioVehiculo;

	@Autowired
	public ControladorVehiculo(ServicioVehiculo servicioVehiculo) {
		this.servicioVehiculo = servicioVehiculo;
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
			// Como la implementación de save de JpaRepository devuelve un tipo
			// <S extends T> S save(S entity), hay que hacer un cast para
			// devolver lo que queramos, ya que recibiremos por defecto el
			// objeto que insertemos en la tabla destino
			return servicioVehiculo.alta(vehiculo);
		} else {
			return (0l);
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
			servicioVehiculo.baja(idVehiculo);
			return idVehiculo;
		} else
			return 0l;
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
			// Como la implementación de save de JpaRepository devuelve un tipo
			// <S extends T> S save(S entity), hay que hacer un cast para
			// devolver lo que queramos, ya que recibiremos por defecto el
			// objeto que insertemos en la tabla destino
			return servicioVehiculo.modificacion(vehiculo);
		} else {
			return 0l;
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
		vehiculoRecuperado = servicioVehiculo.consultaPorId(idVehiculo);

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
		listaRecuperada = servicioVehiculo.consultarTodos();

		return listaRecuperada;
	}
}
