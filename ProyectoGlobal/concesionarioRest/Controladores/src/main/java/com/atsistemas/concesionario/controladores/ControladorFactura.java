package com.atsistemas.concesionario.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atsistemas.concesionario.entidades.Factura;
import com.atsistemas.concesionario.interfaces.servicios.FacturaServicio;

@RestController
@RequestMapping(value = ControladorFactura.BASE_URL)
public class ControladorFactura {

	static final String BASE_URL = "/facturas";

	private FacturaServicio facturaServicio;

	@Autowired
	ControladorFactura(FacturaServicio facturaServicio) {
		this.facturaServicio = facturaServicio;
	}

	/**
	 * Da de alta una factura asignando la clave primaria con la secuencia de BBDD
	 * 
	 * Es necesario que exista la entidad pedido con la que se relaciona.
	 * 
	 * @param pedido
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public long generacionDeFactura(@RequestBody Factura factura) {
		if (factura != null) {
			return facturaServicio.alta(factura);
		} else {
			return 0L;
		}
	}

	@RequestMapping(value = "/{idFactura}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public long CobroDeFacturas(@PathVariable("idFactura") long idFactura) {
		if (idFactura > 0) {
			return facturaServicio.CobroDeFacturas(idFactura);
		} else {
			return 0L;
		}
	}

}
