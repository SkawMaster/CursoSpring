package com.atsistemas.concesionario.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atsistemas.concesionario.entidades.EstadoFactura;
import com.atsistemas.concesionario.entidades.EstadoPedido;
import com.atsistemas.concesionario.entidades.Factura;
import com.atsistemas.concesionario.entidades.Pedido;
import com.atsistemas.concesionario.interfaces.persistencia.FacturaDao;
import com.atsistemas.concesionario.interfaces.persistencia.PedidoDao;
import com.atsistemas.concesionario.interfaces.servicios.FacturaServicio;

@Service
public class ServicioFactura implements FacturaServicio {

	@Autowired
	private PedidoDao pedidoDao;

	@Autowired
	private FacturaDao facturaDao;

	public long CobroDeFacturas(long idFactura) {

		Factura factura = facturaDao.findOne(idFactura);

		if (factura != null) {
			factura.setEstado(EstadoFactura.COBRADA);

			Pedido pedido = pedidoDao.findOne(factura.getPedido().getId());

			if (pedido != null) {
				pedido.setEstado(EstadoPedido.ENTREGADO);
			}
		} else {
			return 0;
		}

		return factura.getId();
	}

}
