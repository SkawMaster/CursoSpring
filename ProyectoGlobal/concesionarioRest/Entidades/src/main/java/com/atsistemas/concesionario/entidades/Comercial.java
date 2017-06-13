package com.atsistemas.concesionario.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Comercial implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1259857019185045064L;

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false)
	private String correo;

	@Column(nullable = false)
	private String telefono;

	@OneToMany(fetch = FetchType.EAGER)
	@JsonIgnoreProperties({ "pedido", "comercial" })
	private Collection<Cliente> clientes;

	@OneToMany(fetch = FetchType.EAGER)
	@JsonIgnoreProperties({ "vehiculo", "comercial", "cliente", "factura" })
	private Collection<Pedido> pedidos;

	public Comercial() {
		super();
	}

	public Comercial(long id, String nombre, String correo, String telefono, Collection<Cliente> clientes,
			Collection<Pedido> pedidos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
		this.clientes = clientes;
		this.pedidos = pedidos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Collection<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Collection<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Collection<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Collection<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientes == null) ? 0 : clientes.hashCode());
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((pedidos == null) ? 0 : pedidos.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
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
		Comercial other = (Comercial) obj;
		if (clientes == null) {
			if (other.clientes != null)
				return false;
		} else if (!clientes.equals(other.clientes))
			return false;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (pedidos == null) {
			if (other.pedidos != null)
				return false;
		} else if (!pedidos.equals(other.pedidos))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comercial [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", telefono=" + telefono
				+ ", clientes=" + clientes + ", pedidos=" + pedidos + "]";
	}

}
