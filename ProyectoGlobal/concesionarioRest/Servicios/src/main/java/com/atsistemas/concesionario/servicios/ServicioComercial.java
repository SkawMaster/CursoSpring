package com.atsistemas.concesionario.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atsistemas.concesionario.entidades.Comercial;
import com.atsistemas.concesionario.interfaces.persistencia.ComercialDao;
import com.atsistemas.concesionario.interfaces.servicios.ComercialServicio;

@Service
public class ServicioComercial implements ComercialServicio {

	@Autowired
	private ComercialDao comercialDao;

	public void setComercialDao(ComercialDao comercialDao) {
		this.comercialDao = comercialDao;
	}

	public long alta(Comercial comercial) {
		return ((Comercial) comercialDao.save(comercial)).getId();
	}

	public long baja(long idComercial) {
		return comercialDao.delete(idComercial);
	}

	public long modificacion(Comercial comercial) {
		return ((Comercial) comercialDao.save(comercial)).getId();
	}

	public Comercial consultaPorId(long id) {
		return comercialDao.findOne(id);
	}

	public List<Comercial> consultarTodos() {
		return comercialDao.findAll();
	}

}
