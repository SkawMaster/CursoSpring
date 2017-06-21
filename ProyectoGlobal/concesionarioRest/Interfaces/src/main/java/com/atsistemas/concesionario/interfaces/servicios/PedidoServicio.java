package com.atsistemas.concesionario.interfaces.servicios;

import com.atsistemas.concesionario.entidades.EstadoPedido;
import com.atsistemas.concesionario.entidades.Pedido;

public interface PedidoServicio {
	
	/**
	 * 
	 * @param pedido
	 * @return
	 */
	public long lanzarNuevoPedido(Pedido pedido);

	/**
	 * 
	 * @param idPedido
	 * @return
	 */
	public EstadoPedido seguimientoDePedido(long idPedido);

	/**
	 * Actualiza el estado del pedido y entrega el pedido (cambia su estado e
	 * entregado) Devuelve el id del pedido entregado
	 * 
	 * @param pedido
	 * @return
	 */
	public long recepcionDePedido(long idPedido);
}
