package com.atsistemas.concesioario.entidades.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.atsistemas.concesionario.entidades.Cliente;
import com.atsistemas.concesionario.entidades.Comercial;
import com.atsistemas.concesionario.entidades.EstadoPedido;
import com.atsistemas.concesionario.entidades.Factura;
import com.atsistemas.concesionario.entidades.Pedido;
import com.atsistemas.concesionario.entidades.Vehiculo;

public class ClienteTest {

	/** JSON
	 * { "id":1, "nombre":"Victor Herrero Cazurro", "correo":"vhc@lol.juas",
	 * "telefono":"900000000", "pedidos":[] }
	 */

	private Cliente clienteTest;
	private ArrayList<Pedido> listaPedidoTest;

	@Before
	public final void inicializarTest() {
		Pedido pedidoTest = new Pedido(01l, new Cliente(), new Comercial(), new Vehiculo(), new Date(),
				EstadoPedido.SIN_STOCK, new Factura());
		listaPedidoTest = new ArrayList<Pedido>();
		listaPedidoTest.add(pedidoTest);

		clienteTest = new Cliente(01l, "Victor Herrero Cazurro", "vhc@lol.juas", "900000000", listaPedidoTest);
	}

	@Test
	public final void testCliente() {
		Cliente clienteTest = new Cliente();
		assertNotNull(clienteTest);
	}

	@Test
	public final void testClienteLongStringStringStringListOfPedido() {
		Pedido pedidoTest = new Pedido(01l, new Cliente(), new Comercial(), new Vehiculo(), new Date(),
				EstadoPedido.SIN_STOCK, new Factura());
		listaPedidoTest = new ArrayList<Pedido>();
		listaPedidoTest.add(pedidoTest);

		Cliente clienteTest = new Cliente(01l, "Victor Herrero Cazurro", "vhc@lol.juas", "900000000", null);
		assertNotNull(clienteTest);
	}

	@Test
	public final void testGetId() {
		assertTrue(01l == clienteTest.getId());
	}

	@Test
	public final void testSetId() {
		clienteTest.setId(10l);
		assertTrue(10l == clienteTest.getId());
	}

	@Test
	public final void testGetNombre() {
		assertTrue("Victor Herrero Cazurro".equals(clienteTest.getNombre()));
	}

	@Test
	public final void testSetNombre() {
		clienteTest.setNombre("test");
		assertTrue("test".equals(clienteTest.getNombre()));
	}

	@Test
	public final void testGetCorreo() {
		assertTrue("vhc@lol.juas".equals(clienteTest.getCorreo()));
	}

	@Test
	public final void testSetCorreo() {
		clienteTest.setCorreo("test");
		assertTrue("test".equals(clienteTest.getCorreo()));
	}

	@Test
	public final void testGetTelefono() {
		assertTrue("900000000".equals(clienteTest.getTelefono()));
	}

	@Test
	public final void testSetTelefono() {
		clienteTest.setTelefono("test");
		assertTrue("test".equals(clienteTest.getTelefono()));
	}

//	@Test
//	public final void testGetPedidos() {
//		assertTrue(01l == clienteTest.getPedidos().get(0).getId());
//	}

//	@Test
//	public final void testSetPedidos() {
//		Pedido pedidoTest = new Pedido(10l, new Cliente(), new Comercial(), new Vehiculo(), new Date(),
//				EstadoPedido.SIN_STOCK, new Factura());
//		listaPedidoTest = new ArrayList<Pedido>();
//		listaPedidoTest.add(pedidoTest);
//		listaPedidoTest.add(pedidoTest);
//		clienteTest.setPedidos(listaPedidoTest);
//
//		assertTrue(10l == clienteTest.getPedidos().get(1).getId());
//	}

}
