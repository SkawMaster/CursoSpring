package com.atsistemas.concesionario.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atsistemas.concesionario.entitades.Factura;

public interface FacturaDao extends JpaRepository<Factura, Long> {

}
