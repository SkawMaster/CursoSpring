package com.atsistemas.concesionario.persistencia.persistenciaJPA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atsistemas.concesionario.entidades.Cliente;
import com.atsistemas.concesionario.interfaces.persistencia.ClienteDao;

public interface JpaClienteDao extends ClienteDao, JpaRepository<Cliente, Long> {

}
