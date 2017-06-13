package com.atsistemas.concesionario.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Factura implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7747080679812295812L;

	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable = false)
	private Date fecha;
	
	@Column(nullable = false)
	private float total;
	
	@OneToOne
	@JsonIgnoreProperties ({"vehiculo","comercial","cliente", "factura"})
	private Pedido pedido;
	
	@Enumerated(EnumType.STRING)
	private EstadoFactura estado;

	public Factura() {
		super();
	}

	public Factura(long id, Date fecha, float total, Pedido pedido, EstadoFactura estado) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.total = total;
		this.pedido = pedido;
		this.estado = estado;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float f) {
		this.total = f;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public EstadoFactura getEstado() {
		return estado;
	}

	public void setEstado(EstadoFactura estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result + Float.floatToIntBits(total);
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
		Factura other = (Factura) obj;
		if (estado != other.estado)
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id != other.id)
			return false;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (Float.floatToIntBits(total) != Float.floatToIntBits(other.total))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", fecha=" + fecha + ", total=" + total + ", pedido=" + pedido + ", estado="
				+ estado + "]";
	}

}
