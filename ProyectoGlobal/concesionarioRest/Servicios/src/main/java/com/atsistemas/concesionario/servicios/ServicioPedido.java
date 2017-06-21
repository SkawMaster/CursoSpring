package com.atsistemas.concesionario.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atsistemas.concesionario.entidades.EstadoPedido;
import com.atsistemas.concesionario.entidades.Pedido;
import com.atsistemas.concesionario.interfaces.persistencia.PedidoDao;
import com.atsistemas.concesionario.interfaces.servicios.PedidoServicio;

@Service
public class ServicioPedido implements PedidoServicio {

	@Autowired
	private PedidoDao pedidoDao;

	public void setPedidoDao(PedidoDao pedidoDao) {
		this.pedidoDao = pedidoDao;
	}

	public long lanzarNuevoPedido(Pedido pedido) {
		return ((Pedido) pedidoDao.save(pedido)).getId();
	}

	public EstadoPedido seguimientoDePedido(long id) {
		return pedidoDao.findOne(id).getEstado();
	}

	public long recepcionDePedido(long idPedido) {
		Pedido pedido = pedidoDao.findOne(idPedido);

		if (pedido != null) {
			pedido.setEstado(EstadoPedido.ENTREGADO);
			return ((Pedido) pedidoDao.save(pedido)).getId();
		} else {
			return 0L;
		}
	}

}
