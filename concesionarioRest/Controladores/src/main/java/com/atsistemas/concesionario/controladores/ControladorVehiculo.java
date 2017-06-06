package com.atsistemas.concesionario.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ControladorVehiculo(VehiculoDao servicioVehiculo){
		this.servicioVehiculo = servicioVehiculo;
	}
	
	@RequestMapping(value="/{vehiculo}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public long alta(@PathVariable("vehiculo") Vehiculo vehiculo){
		return servicioVehiculo.save(vehiculo);
	}
	
	@RequestMapping(value="/{idVehiculo}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public long baja(@PathVariable("idVehiculo") long idVehiculo){
		return servicioVehiculo.delete(idVehiculo);
	}
	
	@RequestMapping(value="/", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public long modificacion(@PathVariable("vehiculo") Vehiculo vehiculo){
		return servicioVehiculo.save(vehiculo);
	}
	
	@RequestMapping(value="/{idVehiculo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Vehiculo consultaPorId(@PathVariable ("idVehiculo") long idVehiculo){
		return servicioVehiculo.findOne(idVehiculo);
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Vehiculo> consultarTodos() {
		return servicioVehiculo.findAll();
	}
}
