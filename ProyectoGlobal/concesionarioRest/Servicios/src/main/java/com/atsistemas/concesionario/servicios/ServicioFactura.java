package com.atsistemas.concesionario.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atsistemas.concesionario.entidades.EstadoFactura;
import com.atsistemas.concesionario.entidades.Factura;
import com.atsistemas.concesionario.interfaces.persistencia.FacturaDao;
import com.atsistemas.concesionario.interfaces.servicios.FacturaServicio;

@Service
public class ServicioFactura implements FacturaServicio {

	@Autowired
	private FacturaDao facturaDao;

	public void setFacturaDao(FacturaDao facturaDao) {
		this.facturaDao = facturaDao;
	}

	public long alta(Factura factura) {
		if (factura != null){
			return ((Factura)facturaDao.save(factura)).getId();
		} else {
			return 0L;
		}
	}
	
	public long CobroDeFacturas(long idFactura) {

		Factura factura = facturaDao.findOne(idFactura);

		if (factura != null) {
			factura.setEstado(EstadoFactura.COBRADA);
		} else {
			return 0;
		}

		return factura.getId();
	}	

}
