package com.atsistemas.concesionario.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3485147608702668445L;

	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	@JsonIgnoreProperties ({"pedido","comercial"})
	private Cliente cliente;
	
	@ManyToOne
	@JsonIgnoreProperties ({"pedido","cliente"})
	private Comercial comercial;
	
	@ManyToOne
	@JsonIgnoreProperties ({"pedido"})
	private Vehiculo vehiculo;
	
	@Column(nullable = false)
	private Date fecha;
	
	@Enumerated(EnumType.STRING)
	private EstadoPedido estado;
	
	@OneToOne
	@JsonIgnoreProperties ({"pedido"})
	private Factura factura;

	public Pedido() {
		super();
	}

	public Pedido(long id, Cliente cliente, Comercial comercial, Vehiculo vehiculo, Date fecha, EstadoPedido estado,
			Factura factura) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.comercial = comercial;
		this.vehiculo = vehiculo;
		this.fecha = fecha;
		this.estado = estado;
		this.factura = factura;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Comercial getComercial() {
		return comercial;
	}

	public void setComercial(Comercial comercial) {
		this.comercial = comercial;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public EstadoPedido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((comercial == null) ? 0 : comercial.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((factura == null) ? 0 : factura.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((vehiculo == null) ? 0 : vehiculo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (comercial == null) {
			if (other.comercial != null)
				return false;
		} else if (!comercial.equals(other.comercial))
			return false;
		if (estado != other.estado)
			return false;
		if (factura == null) {
			if (other.factura != null)
				return false;
		} else if (!factura.equals(other.factura))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id != other.id)
			return false;
		if (vehiculo == null) {
			if (other.vehiculo != null)
				return false;
		} else if (!vehiculo.equals(other.vehiculo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", cliente=" + cliente + ", comercial=" + comercial + ", vehiculo=" + vehiculo
				+ ", fecha=" + fecha + ", estado=" + estado + ", factura=" + factura + "]";
	}

}
