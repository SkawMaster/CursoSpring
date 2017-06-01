package com.atsistemas.concesioario.entidades.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.atsistemas.concesionario.entitades.Cliente;
import com.atsistemas.concesionario.entitades.Comercial;
import com.atsistemas.concesionario.entitades.EstadoPedido;
import com.atsistemas.concesionario.entitades.Factura;
import com.atsistemas.concesionario.entitades.Pedido;
import com.atsistemas.concesionario.entitades.Vehiculo;

public class ComercialTest {

	private Comercial comercialTest;
	private List<Pedido> listaPedidoTest;
	private List<Cliente> listaClienteTest;

	@Before
	public final void inicializarTest() {

		Pedido pedidoTest = new Pedido(01l, new Cliente(), new Comercial(), new Vehiculo(), new Date(),
				EstadoPedido.SIN_STOCK, new Factura());
		listaPedidoTest = new ArrayList<Pedido>();
		listaPedidoTest.add(pedidoTest);

		Cliente clienteTest = new Cliente(01l, "Victor Herrero Cazurro", "vhc@lol.juas", "900000000", listaPedidoTest);
		listaClienteTest = new ArrayList<Cliente>();
		listaClienteTest.add(clienteTest);

		comercialTest = new Comercial(01l, "Luis Miguel Miralles Albero", "lmma@lol.juas", "900000000000",
				listaClienteTest, listaPedidoTest);
	}

	@Test
	public final void testComercial() {
		Comercial comercialTest = new Comercial();
		assertNotNull(comercialTest);
	}

	@Test
	public final void testComercialLongStringStringStringClienteListOfPedido() {
		Comercial comercialTest = new Comercial(01l, "Luis Miguel Miralles Albero", "lmma@lol.juas", "900000000000",
				listaClienteTest, null);
		assertNotNull(comercialTest);
	}

	@Test
	public final void testGetId() {
		assertTrue(01l == comercialTest.getId());
	}

	@Test
	public final void testSetId() {
		comercialTest.setId(10l);
		assertTrue(10l == comercialTest.getId());
	}

	@Test
	public final void testGetNombre() {
		assertTrue("Luis Miguel Miralles Albero".equals(comercialTest.getNombre()));
	}

	@Test
	public final void testSetNombre() {
		comercialTest.setNombre("test");
		assertTrue("test".equals(comercialTest.getNombre()));
	}

	@Test
	public final void testGetCorreo() {
		assertTrue("lmma@lol.juas".equals(comercialTest.getCorreo()));
	}

	@Test
	public final void testSetCorreo() {
		comercialTest.setCorreo("test");
		assertTrue("test".equals(comercialTest.getCorreo()));
	}

	@Test
	public final void testGetTelefono() {
		assertTrue("900000000000".equals(comercialTest.getTelefono()));
	}

	@Test
	public final void testSetTelefono() {
		comercialTest.setTelefono("test");
		assertTrue("test".equals(comercialTest.getTelefono()));
	}

	@Test
	public final void testGetClientes() {
		assertTrue("Victor Herrero Cazurro".equals(comercialTest.getClientes().get(0).getNombre()));
	}

	@Test
	public final void testSetClientes() {
		Cliente clienteTest = new Cliente(02l, "Tony Stark", "ts@vengadores.com", "969696969", null);
		listaClienteTest = new ArrayList<Cliente>();
		listaClienteTest.add(clienteTest);
		comercialTest.setClientes(listaClienteTest);
		assertTrue("Tony Stark".equals(comercialTest.getClientes().get(0).getNombre()));
	}

	@Test
	public final void testGetPedidos() {
		assertNotNull(comercialTest.getPedidos().get(0));
	}

	@Test
	public final void testSetPedidos() {
		Pedido pedidoTest = new Pedido(01l, new Cliente(), new Comercial(), new Vehiculo(), new Date(),
				EstadoPedido.SIN_STOCK, new Factura());
		listaPedidoTest = new ArrayList<Pedido>();
		listaPedidoTest.add(pedidoTest);
		listaPedidoTest.add(pedidoTest);
		comercialTest.setPedidos(listaPedidoTest);

		assertNotNull(comercialTest.getPedidos().get(1));
	}

}
