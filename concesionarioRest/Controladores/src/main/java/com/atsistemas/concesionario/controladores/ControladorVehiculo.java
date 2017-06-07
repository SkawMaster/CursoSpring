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

@RestController
@RequestMapping(value = ControladorVehiculo.BASE_URL)
public class ControladorVehiculo {

	static final String BASE_URL = "/vehiculos";

	private VehiculoDao servicioVehiculo;

	@Autowired
	public ControladorVehiculo(VehiculoDao servicioVehiculo) {
		this.servicioVehiculo = servicioVehiculo;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public long alta(@RequestBody Vehiculo vehiculo) {

		if (vehiculo != null) {
			// Como la implementación de save de JpaRepository devuelve un tipo
			// <S extends T> S save(S entity), hay que hacer un cast para
			// devolver lo que queramos, ya que recibiremos por defecto el
			// objeto que insertemos en la tabla destino
			return ((Vehiculo) servicioVehiculo.save(vehiculo)).getId();
		} else {
			return (0l);
		}
	}

	@RequestMapping(value = "/{idVehiculo}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public long baja(@PathVariable("idVehiculo") long idVehiculo) {

		if (idVehiculo > 0) {
			servicioVehiculo.delete(idVehiculo);
			return idVehiculo;
		} else
			return 0l;
	}

	@RequestMapping(value = "/", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public long modificacion(@RequestBody Vehiculo vehiculo) {

		if (vehiculo != null) {
			// Como la implementación de save de JpaRepository devuelve un tipo
			// <S extends T> S save(S entity), hay que hacer un cast para
			// devolver lo que queramos, ya que recibiremos por defecto el
			// objeto que insertemos en la tabla destino
			return ((Vehiculo) servicioVehiculo.save(vehiculo)).getId();
		} else {
			return 0l;
		}
	}

	@RequestMapping(value = "/{idVehiculo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Vehiculo consultaPorId(@PathVariable("idVehiculo") long idVehiculo) {

		Vehiculo vehiculoRecuperado;
		vehiculoRecuperado = servicioVehiculo.findOne(idVehiculo);

		return vehiculoRecuperado;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Vehiculo> consultarTodos() {

		List<Vehiculo> listaRecuperada;
		listaRecuperada = servicioVehiculo.findAll();

		return listaRecuperada;
	}
}
