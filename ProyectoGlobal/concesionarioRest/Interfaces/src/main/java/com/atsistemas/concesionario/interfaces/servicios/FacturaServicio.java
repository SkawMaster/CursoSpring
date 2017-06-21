package com.atsistemas.concesionario.interfaces.servicios;

import com.atsistemas.concesionario.entidades.Factura;

public interface FacturaServicio {

	
	public long alta (Factura factura);
	/**
	 * Cobra la factura cambiando su estado a PAGADO
	 * @param idFactura
	 * @return
	 */
	public long CobroDeFacturas(long idFactura);
}
