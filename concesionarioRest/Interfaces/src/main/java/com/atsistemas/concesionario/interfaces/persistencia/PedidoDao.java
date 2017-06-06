package com.atsistemas.concesionario.interfaces.persistencia;

import java.util.List;

import com.atsistemas.concesionario.entidades.Pedido;

public interface PedidoDao {

	public long save(Pedido pedido);

	public long delete(long idPedido);

	public Pedido findOne(long id);

	public List<Pedido> findAll();
}
