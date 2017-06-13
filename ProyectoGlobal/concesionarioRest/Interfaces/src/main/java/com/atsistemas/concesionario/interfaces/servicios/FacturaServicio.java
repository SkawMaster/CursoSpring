package com.atsistemas.concesionario.interfaces.servicios;

public interface FacturaServicio {

	/**
	 * Cobra la factura y entrega el pedido (cambia su estado e entregado)
	 */
	public long CobroDeFacturas(long idFactura);
}
