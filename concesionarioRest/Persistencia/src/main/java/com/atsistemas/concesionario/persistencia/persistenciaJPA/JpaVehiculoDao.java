package com.atsistemas.concesionario.persistencia.persistenciaJPA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atsistemas.concesionario.entidades.Vehiculo;
import com.atsistemas.concesionario.interfaces.persistencia.VehiculoDao;

public interface JpaVehiculoDao extends VehiculoDao, JpaRepository<Vehiculo, Long> {

}
