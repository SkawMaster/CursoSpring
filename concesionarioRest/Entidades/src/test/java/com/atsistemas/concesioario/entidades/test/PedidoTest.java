package com.atsistemas.concesioario.entidades.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.atsistemas.concesionario.entitades.Cliente;
import com.atsistemas.concesionario.entitades.Comercial;
import com.atsistemas.concesionario.entitades.EstadoFactura;
import com.atsistemas.concesionario.entitades.EstadoPedido;
import com.atsistemas.concesionario.entitades.Factura;
import com.atsistemas.concesionario.entitades.Pedido;
import com.atsistemas.concesionario.entitades.Vehiculo;

public class PedidoTest {

	private Pedido pedidoTest;
	private Cliente clienteTest;
	private Comercial comercialTest;
	private Vehiculo vehiculoTest;
	private Factura facturaTest;
	private Date fechaTest;
	private SimpleDateFormat simpleDateFormat;

	@Before
	public void inicializarTest() throws ParseException {
		pedidoTest = new Pedido(01l, new Cliente(), new Comercial(), new Vehiculo(), new Date(), EstadoPedido.SIN_STOCK,
				new Factura());

		clienteTest = new Cliente(01l, "Victor Herrero Cazurro", "vhc@lol.juas", "900000000", null);
		List<Cliente> listaClientesTest = new ArrayList<Cliente>();
		listaClientesTest.add(clienteTest);

		comercialTest = new Comercial(01l, "Luis Miguel Miralles Albero", "lmma@lol.juas", "900000000000",
				listaClientesTest, null);
		vehiculoTest = new Vehiculo(01l, "Coche fantástico", "Trans Am Firebird", "Negro", "5700CC", 20000f);
		facturaTest = new Factura(01l, new Date(), new BigDecimal(0), new Pedido(), EstadoFactura.NO_COBRADA);

		simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		fechaTest = simpleDateFormat.parse("1981-04-13 00:12");
	}

	@Test
	public final void testPedido() {
		Pedido pedidoTest = new Pedido();

		assertNotNull(pedidoTest);
	}

	@Test
	public final void testPedidoLongClienteComercialVehiculoDateEstadoFacturaFactura() {
		Pedido pedidoTest = new Pedido(01l, new Cliente(), new Comercial(), new Vehiculo(), new Date(),
				EstadoPedido.SIN_STOCK, new Factura());

		assertNotNull(pedidoTest);
	}

	@Test
	public final void testGetId() {
		assertTrue(01l == pedidoTest.getId());
	}

	@Test
	public final void testSetId() {
		pedidoTest.setId(10l);
		assertTrue(10l == pedidoTest.getId());
	}

	@Test
	public final void testGetCliente() {
		assertNotNull(pedidoTest.getCliente());
	}

	@Test
	public final void testSetCliente() {
		pedidoTest.setCliente(clienteTest);
		assertTrue("Victor Herrero Cazurro".equals(pedidoTest.getCliente().getNombre()));
	}

	@Test
	public final void testGetComercial() {
		assertNotNull(pedidoTest.getComercial());
	}

	@Test
	public final void testSetComercial() {
		pedidoTest.setComercial(comercialTest);
		assertTrue("Luis Miguel Miralles Albero".equals(pedidoTest.getComercial().getNombre()));
	}

	@Test
	public final void testGetVehiculo() {
		assertNotNull(pedidoTest.getVehiculo());
	}

	@Test
	public final void testSetVehiculo() {
		pedidoTest.setVehiculo(vehiculoTest);
		assertTrue("Coche fantástico".equals(pedidoTest.getVehiculo().getDescripcion()));
	}

	@Test
	public final void testGetFecha() {
		assertNotNull(pedidoTest.getFecha());
	}

	@Test
	public final void testSetFecha() {
		pedidoTest.setFecha(fechaTest);
		assertTrue("1981-04-13 00:12".equals(simpleDateFormat.format(pedidoTest.getFecha())));
	}

	@Test
	public final void testGetEstado() {
		assertNotNull(pedidoTest.getEstado());
	}

	@Test
	public final void testSetEstado() {
		pedidoTest.setEstado(EstadoPedido.EN_PROCESO);
		assertTrue(EstadoPedido.EN_PROCESO.equals(pedidoTest.getEstado()));
	}

	@Test
	public final void testGetFactura() {
		assertNotNull(pedidoTest.getFactura());
	}

	@Test
	public final void testSetFactura() {
		pedidoTest.setFactura(facturaTest);
		assertTrue(EstadoFactura.NO_COBRADA.equals(facturaTest.getEstado()));
	}

}
