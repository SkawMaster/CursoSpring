package com.atsistemas.concesionario.persistencia.persistenciaJPA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atsistemas.concesionario.entidades.Pedido;
import com.atsistemas.concesionario.interfaces.persistencia.PedidoDao;

public interface JpaPedidoDao extends PedidoDao, JpaRepository<Pedido, Long> {

}
