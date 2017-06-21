package com.atsistemas.concesionario.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Long> alta(@RequestBody Vehiculo vehiculo) {

		if (vehiculo != null) {
			try {
				return new ResponseEntity<Long>(vehiculoServicio.alta(vehiculo), HttpStatus.CREATED);
			} catch (Exception exception) {
				return new ResponseEntity<Long>(0L, HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<Long>(0L, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Elimina de BBDD el vehículo con el identificador idVehiculo
	 * 
	 * @param idVehiculo
	 * @return
	 */
	@RequestMapping(value = "/{idVehiculo}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Long> baja(@PathVariable("idVehiculo") long idVehiculo) {

		if (idVehiculo > 0) {			
			try {
				return new ResponseEntity<Long>(vehiculoServicio.baja(idVehiculo), HttpStatus.NO_CONTENT);
			} catch (Exception exception) {
				return new ResponseEntity<Long>(0L, HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<Long>(0L, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Modifica el vehículo de BBDD con el vehículo pasado por parámetro
	 * 
	 * @param vehiculo
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Long> modificacion(@RequestBody Vehiculo vehiculo) {

		if (vehiculo != null) {			
			try {
				return new ResponseEntity<Long>(vehiculoServicio.modificacion(vehiculo), HttpStatus.OK);
			} catch (Exception exception) {
				return new ResponseEntity<Long>(0L, HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<Long>(0L, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Devuelve el vehículo con el identificador idVehiculo
	 * 
	 * @param idVehiculo
	 * @return
	 */
	@RequestMapping(value = "/{idVehiculo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Vehiculo> consultaPorId(@PathVariable("idVehiculo") long idVehiculo) {		
		try {
			return new ResponseEntity<Vehiculo>(vehiculoServicio.consultaPorId(idVehiculo), HttpStatus.OK);
		} catch (Exception exception) {
			return new ResponseEntity<Vehiculo>(new Vehiculo(), HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Devuelve una lista de todos los vehículos de la BBDD
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Vehiculo>> consultarTodos() {
		try {
			return new ResponseEntity<List<Vehiculo>>(vehiculoServicio.consultarTodos(), HttpStatus.OK);
		} catch (Exception exception) {
			return new ResponseEntity<List<Vehiculo>>(new ArrayList<Vehiculo>(), HttpStatus.NOT_FOUND);
		}
	}
}
