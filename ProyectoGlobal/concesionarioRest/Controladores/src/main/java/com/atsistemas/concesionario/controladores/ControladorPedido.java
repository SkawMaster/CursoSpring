package com.atsistemas.concesionario.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atsistemas.concesionario.entidades.EstadoPedido;
import com.atsistemas.concesionario.entidades.Pedido;
import com.atsistemas.concesionario.interfaces.servicios.PedidoServicio;

@RestController
@RequestMapping(value = ControladorPedido.BASE_URL)
public class ControladorPedido {

	final static String BASE_URL = "/pedidos";

	private PedidoServicio pedidoServicio;

	@Autowired
	public ControladorPedido(PedidoServicio pedidoServicio) {
		this.pedidoServicio = pedidoServicio;
	}

	/**
	 * Da de alta un pedido asignando la clave primaria con la secuencia de BBDD
	 * 
	 * Es necesario que existan las entidades Vehiculo, Comercial y Cliente con
	 * las que se relaciona.
	 * 
	 * @param pedido
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Long> lanzarNuevoPedido(@RequestBody Pedido pedido) {

		if (pedido != null) {
			try {
				return new ResponseEntity<Long>(pedidoServicio.lanzarNuevoPedido(pedido), HttpStatus.CREATED);
			} catch (Exception exception) {
				return new ResponseEntity<Long>(0L, HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<Long>(0L, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Devuelve el estado del pedido (EN_PROCESO, ENTREGADO o SIN_STOCK)
	 * 
	 * En caso de no existir el pedido, devuelve el estado ERROR.
	 * 
	 * @param idPedido
	 * @return
	 */
	@RequestMapping(value = "/{idPedido}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<EstadoPedido> seguimientoDePedido(@PathVariable("idPedido") long idPedido) {
		if (idPedido > 0) {
			try {
				return new ResponseEntity<EstadoPedido>(pedidoServicio.seguimientoDePedido(idPedido), HttpStatus.FOUND);
			} catch (Exception exception) {
				return new ResponseEntity<EstadoPedido>(EstadoPedido.ERROR, HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<EstadoPedido>(EstadoPedido.ERROR, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Modifica el estado del pedido de EN_PROCESO a ENTREGADO
	 * 
	 * @param idPedido
	 * @return
	 */
	@RequestMapping(value = "/{idPedido}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Long> recepcionDePedido(@PathVariable("idPedido") long idPedido) {
		if (idPedido > 0) {
			try {
				return new ResponseEntity<Long>(pedidoServicio.recepcionDePedido(idPedido), HttpStatus.OK);
			} catch (Exception exception) {
				return new ResponseEntity<Long>(0L, HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<Long>(0L, HttpStatus.NOT_FOUND);
		}
	}

}
