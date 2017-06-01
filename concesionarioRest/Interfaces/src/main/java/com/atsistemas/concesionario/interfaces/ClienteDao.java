package com.atsistemas.concesionario.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atsistemas.concesionario.entitades.Cliente;

public interface ClienteDao extends JpaRepository<Cliente, Long> {

}
