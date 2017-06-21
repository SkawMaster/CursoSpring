package com.atsistemas.concesionario.controladores.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.atsistemas.concesionario.controladores.ControladorVehiculo;
import com.atsistemas.concesionario.entidades.Vehiculo;
import com.atsistemas.concesionario.interfaces.servicios.VehiculoServicio;

@RunWith(MockitoJUnitRunner.class)
public class ControllerVehiculoTest {

	private Vehiculo vehiculoTest;
	private ControladorVehiculo controladorVehiculo;

	@Mock
	private VehiculoServicio vehiculoServicio;

	@Before
	public final void setUp() {
		vehiculoTest = new Vehiculo(01l, "Coche fantástico", "Trans Am Firebird", "Negro", "5700CC", 20000f);
		
		try {
			when(vehiculoServicio.alta(isA(Vehiculo.class))).thenReturn(1L);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		controladorVehiculo = new ControladorVehiculo(vehiculoServicio);
	}

	@Test
	public void shouldBeNotNull() {
		assertNotNull(controladorVehiculo);
	}

	@Test
	public void shouldBeNull() {
		ControladorVehiculo controladorVehiculo = null;
		assertNull(controladorVehiculo);
	}

	@Test
	public void altaShouldReturnLongAndCreatedWithNotNullVehiculo() {
		ResponseEntity<Long> respuesta = controladorVehiculo.alta(vehiculoTest);
		assertTrue(respuesta.getStatusCode() == HttpStatus.CREATED);
		assertTrue(respuesta.getBody() > 0L);
	}

	@Test
	public void altaShouldReturnLongAndNotFoundWithNullVehiculo() {
		ResponseEntity<Long> respuesta = controladorVehiculo.alta(null);
		assertTrue(respuesta.getStatusCode() == HttpStatus.NOT_FOUND);
		assertTrue(respuesta.getBody() == 0L);
	}
	
	@Test
	public void altaShouldReturnLongAndNotFoundWithNullVehiculoByException() {
		try {
			when(vehiculoServicio.alta(isA(Vehiculo.class))).thenThrow(new Exception());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ResponseEntity<Long> respuesta = controladorVehiculo.alta(new Vehiculo());
		assertTrue(respuesta.getStatusCode() == HttpStatus.NOT_FOUND);
		assertTrue(respuesta.getBody() == 0L);
	}

	@Test
	public void testBaja() {
		fail("Not yet implemented");
	}

	@Test
	public void testModificacion() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsultaPorId() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsultarTodos() {
		fail("Not yet implemented");
	}

}
