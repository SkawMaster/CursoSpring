package com.atsistemas.concesionario.persistencia.persistenciaJPA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atsistemas.concesionario.entidades.Factura;
import com.atsistemas.concesionario.interfaces.persistencia.FacturaDao;

public interface JpaFacturaDao extends FacturaDao, JpaRepository<Factura, Long> {

}
