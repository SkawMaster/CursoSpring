package com.atsistemas.concesionario.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atsistemas.concesionario.entitades.Vehiculo;

public interface VehiculoDao extends JpaRepository<Vehiculo, Long> {

}
