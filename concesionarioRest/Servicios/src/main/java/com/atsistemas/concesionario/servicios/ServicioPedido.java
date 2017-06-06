package com.atsistemas.concesionario.servicios;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atsistemas.concesionario.entidades.EstadoFactura;
import com.atsistemas.concesionario.entidades.EstadoPedido;
import com.atsistemas.concesionario.entidades.Factura;
import com.atsistemas.concesionario.entidades.Pedido;
import com.atsistemas.concesionario.interfaces.persistencia.FacturaDao;
import com.atsistemas.concesionario.interfaces.persistencia.PedidoDao;
import com.atsistemas.concesionario.interfaces.servicios.PedidoServicio;

@Service
public class ServicioPedido implements PedidoServicio {

	@Autowired
	private PedidoDao pedidoDao;

	@Autowired
	private FacturaDao facturaDao;

	public void setPedidoDao(PedidoDao pedidoDao) {
		this.pedidoDao = pedidoDao;
	}

	public void setFacturaDao(FacturaDao facturaDao) {
		this.facturaDao = facturaDao;
	}

	public long lanzarNuevoPedido(Pedido pedido) {
		return pedidoDao.save(pedido);
	}

	public EstadoPedido seguimientoDePedido(long id) {
		return pedidoDao.findOne(id).getEstado();
	}

	public long[] recepcionDePedido(long idPedido) {
		Pedido pedido = pedidoDao.findOne(idPedido);
		Factura factura;
		if (pedido != null) {
			factura = pedido.getFactura();

			if (factura == null) {
				factura = new Factura();
				factura.setFecha(Calendar.getInstance().getTime());
				factura.setEstado(EstadoFactura.NO_COBRADA);
				factura.setPedido(pedido);
				factura.setTotal(pedido.getVehiculo().getPrecio());

				factura.setId(facturaDao.save(factura));

				if (factura.getId() == 0) {
					return new long[] { 0, 0 };
				} else {
					return new long[] { pedido.getId(), factura.getId() };
				}

			}
		}

		return new long[] { 0, 0 };
	}

}
