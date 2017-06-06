package com.atsistemas.concesionario.interfaces.persistencia;

import java.util.List;

import com.atsistemas.concesionario.entidades.Factura;

public interface FacturaDao {

	public long save(Factura factura);

	public long delete(long idFactura);

	public Factura findOne(long id);

	public List<Factura> findAll();
}
