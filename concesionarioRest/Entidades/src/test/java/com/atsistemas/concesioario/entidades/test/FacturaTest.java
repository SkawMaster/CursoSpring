package com.atsistemas.concesioario.entidades.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.atsistemas.concesionario.entitades.Cliente;
import com.atsistemas.concesionario.entitades.Comercial;
import com.atsistemas.concesionario.entitades.EstadoFactura;
import com.atsistemas.concesionario.entitades.EstadoPedido;
import com.atsistemas.concesionario.entitades.Factura;
import com.atsistemas.concesionario.entitades.Pedido;
import com.atsistemas.concesionario.entitades.Vehiculo;

public class FacturaTest {

	private Factura facturaTest;
	private Pedido pedidoTest;
	private Date fechaTest;
	private SimpleDateFormat simpleDateFormat;

	@Before
	public void inicializarTest() throws ParseException {
		facturaTest = new Factura(01l, new Date(), new BigDecimal(0), new Pedido(), EstadoFactura.NO_COBRADA);
		pedidoTest = new Pedido(01l, new Cliente(), new Comercial(), new Vehiculo(), new Date(), EstadoPedido.SIN_STOCK,
				new Factura());
		simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		fechaTest = simpleDateFormat.parse("1981-04-13 00:12");
	}

	@Test
	public final void testFactura() {
		Pedido pedidoTest = new Pedido();
		assertNotNull(pedidoTest);
	}

	@Test
	public final void testFacturaLongDateBigDecimalPedidoEstadoPedido() {
		Pedido pedidoTest = new Pedido(01l, new Cliente(), new Comercial(), new Vehiculo(), new Date(),
				EstadoPedido.SIN_STOCK, new Factura());
		assertNotNull(pedidoTest);
	}

	@Test
	public final void testGetId() {
		assertTrue(01l == facturaTest.getId());
	}

	@Test
	public final void testSetId() {
		facturaTest.setId(10l);
		assertTrue(10l == facturaTest.getId());
	}

	@Test
	public final void testGetFecha() {
		assertNotNull(facturaTest.getFecha());
	}

	@Test
	public final void testSetFecha() {
		facturaTest.setFecha(fechaTest);
		assertTrue("1981-04-13 00:12".equals(simpleDateFormat.format(facturaTest.getFecha())));
	}

	@Test
	public final void testGetTotal() {
		assertNotNull(facturaTest.getTotal());
	}

	@Test
	public final void testSetTotal() {
		facturaTest.setTotal(new BigDecimal(100));
		assertTrue(100 == facturaTest.getTotal().intValueExact());
	}

	@Test
	public final void testGetPedido() {
		assertNotNull(facturaTest.getPedido());
	}

	@Test
	public final void testSetPedido() {
		facturaTest.setPedido(pedidoTest);
		assertTrue(01l == facturaTest.getPedido().getId());
	}

	@Test
	public final void testGetEstado() {
		assertNotNull(facturaTest.getEstado());
	}

	@Test
	public final void testSetEstado() {
		facturaTest.setEstado(EstadoFactura.COBRADA);
		assertTrue(EstadoFactura.COBRADA.equals(facturaTest.getEstado()));
	}

}
