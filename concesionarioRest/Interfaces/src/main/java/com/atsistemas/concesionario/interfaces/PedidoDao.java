package com.atsistemas.concesionario.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atsistemas.concesionario.entitades.Pedido;

public interface PedidoDao extends JpaRepository<Pedido, Long> {

}
