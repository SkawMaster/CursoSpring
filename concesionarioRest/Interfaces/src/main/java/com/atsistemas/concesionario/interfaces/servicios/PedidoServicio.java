package com.atsistemas.concesionario.interfaces.servicios;

import com.atsistemas.concesionario.entidades.EstadoPedido;
import com.atsistemas.concesionario.entidades.Pedido;

public interface PedidoServicio {

	public long lanzarNuevoPedido(Pedido pedido);
	public EstadoPedido seguimientoDePedido(long idPedido);
	/**
	 * Actualiza el estado del pedido y genera la factura correspondiente.
	 * Devuelve la pareja de ids de Pedido y Factura asociada.
	 * @param pedido
	 * @return
	 */
	public long[] recepcionDePedido(long idPedido);
}
