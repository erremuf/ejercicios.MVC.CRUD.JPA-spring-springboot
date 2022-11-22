package com.rmf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="facturas")
public class Factura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_factura")
	private Integer idFactura;
	
	@Column(name="nif")
	@NotBlank
	private String nifCliente;
	
	@Column(name="nombre")
	@NotEmpty
	private String nombre;
	
	@Column(name="apellidos")
	@NotEmpty
	private String apellidos;
	
	@Column(name="total")
	@NotNull
	private double valor;
	
	
/////////////////////////// CONSTRUCTORS
	
	public Factura() {}
	public Factura(Integer idFactura, @NotBlank String nifCliente, @NotEmpty String nombre, @NotEmpty String apellidos,
				@NotNull double valor) {
			this.nifCliente = nifCliente;
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.valor = valor;
		}
	
		
/////////////////////////// GETTERS AND SETTERS
	
	public Integer getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}
	public String getNifCliente() {
		return nifCliente;
	}
	public void setNifCliente(String nifCliente) {
		this.nifCliente = nifCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	
	

}
