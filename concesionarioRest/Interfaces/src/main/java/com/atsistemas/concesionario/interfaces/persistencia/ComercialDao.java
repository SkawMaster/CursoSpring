package com.atsistemas.concesionario.interfaces.persistencia;

import java.util.List;

import com.atsistemas.concesionario.entidades.Comercial;

public interface ComercialDao {

	public Comercial save(Comercial comercial);

	public long delete(long idComercial);

	public Comercial findOne(long id);

	public List<Comercial> findAll();
}
