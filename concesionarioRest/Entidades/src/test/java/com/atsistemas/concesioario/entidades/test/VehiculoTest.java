package com.atsistemas.concesioario.entidades.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.atsistemas.concesionario.entitades.Vehiculo;

public class VehiculoTest {

	private Vehiculo vehiculoTest;

	@Before
	public void inicializarTest() {
		vehiculoTest = new Vehiculo(01l, "Coche fantástico", "Trans Am Firebird", "Negro", "5700CC", 20000f);
	}

	@Test
	public final void testVehiculo() {
		Vehiculo vehiculoTest = new Vehiculo();

		assertNotNull(vehiculoTest);
	}

	@Test
	public final void testVehiculoLongStringStringStringStringFloatº() {
		Vehiculo vehiculoTest = new Vehiculo(01l, "Coche fantástico", "Trans Am Firebird", "Negro", "5700CC", 20000f);

		assertNotNull(vehiculoTest);
	}

	@Test
	public final void testGetId() {
		assertTrue(vehiculoTest.getId() == 01l);
	}

	@Test
	public final void testSetId() {
		vehiculoTest.setId(00l);
		assertTrue(vehiculoTest.getId() == 00l);
	}

	@Test
	public final void testGetDescripcion() {
		assertTrue("Coche fantástico".equals(vehiculoTest.getDescripcion()));
	}

	@Test
	public final void testSetDescripcion() {
		vehiculoTest.setDescripcion("test");
		assertTrue("test".equals(vehiculoTest.getDescripcion()));
	}

	@Test
	public final void testGetModelo() {
		assertTrue("Trans Am Firebird".equals(vehiculoTest.getModelo()));
	}

	@Test
	public final void testSetModelo() {
		vehiculoTest.setModelo("test");
		assertTrue("test".equals(vehiculoTest.getModelo()));
	}

	@Test
	public final void testGetColor() {
		assertTrue("Negro".equals(vehiculoTest.getColor()));
	}

	@Test
	public final void testSetColor() {
		vehiculoTest.setColor("test");
		assertTrue("test".equals(vehiculoTest.getColor()));
	}

	@Test
	public final void testGetMotor() {
		assertTrue("5700CC".equals(vehiculoTest.getMotor()));
	}

	@Test
	public final void testSetMotor() {
		vehiculoTest.setMotor("test");
		assertTrue("test".equals(vehiculoTest.getMotor()));
	}

	@Test
	public final void testGetPrecio() {
		assertTrue(20000f == vehiculoTest.getPrecio());
	}

	@Test
	public final void testSetPrecio() {
		vehiculoTest.setPrecio(10f);
		assertTrue(10f == vehiculoTest.getPrecio());
	}

}
