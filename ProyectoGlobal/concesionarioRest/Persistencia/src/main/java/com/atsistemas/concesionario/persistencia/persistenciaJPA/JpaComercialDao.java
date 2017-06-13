package com.atsistemas.concesionario.persistencia.persistenciaJPA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atsistemas.concesionario.entidades.Comercial;
import com.atsistemas.concesionario.interfaces.persistencia.ComercialDao;

public interface JpaComercialDao extends ComercialDao, JpaRepository<Comercial, Long> {

}
