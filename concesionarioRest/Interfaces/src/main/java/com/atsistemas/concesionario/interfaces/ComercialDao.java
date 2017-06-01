package com.atsistemas.concesionario.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atsistemas.concesionario.entitades.Comercial;

public interface ComercialDao extends JpaRepository<Comercial, Long> {

}
