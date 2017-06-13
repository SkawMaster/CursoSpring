package com.atsistemas.concesionario.interfaces.servicios;

import java.util.List;

import com.atsistemas.concesionario.entidades.Comercial;

public interface ComercialServicio {

	public long alta(Comercial comercial);

	public long baja(long idComercial);

	public long modificacion(Comercial comercial);

	public Comercial consultaPorId(long id);

	public List<Comercial> consultarTodos();
}
