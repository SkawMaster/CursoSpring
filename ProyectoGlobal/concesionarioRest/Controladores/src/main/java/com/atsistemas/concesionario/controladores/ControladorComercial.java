package com.atsistemas.concesionario.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atsistemas.concesionario.entidades.Comercial;
import com.atsistemas.concesionario.interfaces.servicios.ComercialServicio;
import com.atsistemas.concesionario.interfaces.servicios.VehiculoServicio;

@RestController
@RequestMapping(value = ControladorComercial.BASE_URL)
public class ControladorComercial {

	final static String BASE_URL = "/comerciales";

	private ComercialServicio comercialServicio;

	@Autowired
	public ControladorComercial(ComercialServicio comercialServicio) {
		this.comercialServicio = comercialServicio;
	}
	
	/**
	 * Da de alta un comercial asignando la clave primaria con la secuencia de
	 * BBDD
	 * 
	 * @param comercial
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public long alta(@RequestBody Comercial comercial) {
		
		if (comercial != null) {
			return comercialServicio.alta(comercial);
		} else {
			return 0L;
		}
	}

	/**
	 * Elimina de BBDD el comercial con el identificador idComercial
	 * 
	 * @param idComercial
	 * @return
	 */
	@RequestMapping(value = "/{idComercial}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public long baja(@RequestParam long idComercial) {
		
		if (idComercial > 0) {
			return comercialServicio.baja(idComercial);
		} else {
			return 0L;
		}
	}

	/**
	 * Modifica el comercial de BBDD con el comercial pasado por parámetro
	 * 
	 * @param comercial
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public long modificacion(@RequestBody Comercial comercial) {
		
		if (comercial != null) {
			return comercialServicio.modificacion(comercial);
		} else {
			return 0L;
		}
	}

	/**
	 * Devuelve el comercial con el identificador idComercial
	 * 
	 * @param idComercial
	 * @return
	 */
	@RequestMapping(value = "/{idComercial}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comercial consultaPorId(@RequestParam long idComercial) {
		
		Comercial comercialDevuelto = new Comercial();
		comercialDevuelto = comercialServicio.consultaPorId(idComercial);

		return comercialDevuelto;
	}

	/**
	 * Devuelve una lista de todos los comerciales de la BBDD
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Comercial> consultarTodos() {

		List<Comercial> listaComerciales;
		listaComerciales = comercialServicio.consultarTodos();

		return listaComerciales;
	}
}
