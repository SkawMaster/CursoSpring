package com.atsistemas.concesioario.entidades.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.atsistemas.concesionario.entidades.Cliente;
import com.atsistemas.concesionario.entidades.Comercial;
import com.atsistemas.concesionario.entidades.EstadoPedido;
import com.atsistemas.concesionario.entidades.Factura;
import com.atsistemas.concesionario.entidades.Pedido;
import com.atsistemas.concesionario.entidades.Vehiculo;

public class ComercialTest {

	/** JSON
	 * { "id":1, "nombre":"Luis Miguel Miralles Albero", "correo":"lmma@lol.juas",
	 * "telefono":"900000000", "clientes":[], "pedidos":[] }
	 */
	
	private Comercial comercialTest;
	private Set<Pedido> listaPedidoTest;
	private Set<Cliente> listaClienteTest;
	private Cliente clienteTest;
	
	@Before
	public final void setUp() {

		Pedido pedidoTest = new Pedido(01l, new Cliente(), new Comercial(), new Vehiculo(), new Date(),
				EstadoPedido.SIN_STOCK, new Factura());
		listaPedidoTest = new LinkedHashSet<Pedido>();
		listaPedidoTest.add(pedidoTest);

		clienteTest = new Cliente(01l, "Victor Herrero Cazurro", "vhc@lol.juas", "900000000", listaPedidoTest);
		listaClienteTest = new LinkedHashSet<Cliente>();
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
		assertTrue(comercialTest.getClientes().contains(clienteTest));
	}

	@Test
	public final void testSetClientes() {
		Cliente clienteTest = new Cliente(02l, "Tony Stark", "ts@vengadores.com", "969696969", null);
		listaClienteTest = new LinkedHashSet<Cliente>();
		listaClienteTest.add(clienteTest);
		comercialTest.setClientes(listaClienteTest);
		assertTrue(comercialTest.getClientes().contains(clienteTest));
	}

	@Test
	public final void testGetPedidos() {
		assertNotNull(comercialTest.getPedidos());
	}

	@Test
	public final void testSetPedidos() {
		listaPedidoTest = new LinkedHashSet<Pedido>();
		
		Pedido pedidoTest = new Pedido(01l, new Cliente(), new Comercial(), new Vehiculo(), new Date(),
				EstadoPedido.SIN_STOCK, new Factura());
		
		listaPedidoTest.add(pedidoTest);
		
		pedidoTest = new Pedido(02l, new Cliente(), new Comercial(), new Vehiculo(), new Date(),
				EstadoPedido.SIN_STOCK, new Factura());
		
		listaPedidoTest.add(pedidoTest);
		comercialTest.setPedidos(listaPedidoTest);

		assertTrue(comercialTest.getPedidos().size() == 2);
	}

}
