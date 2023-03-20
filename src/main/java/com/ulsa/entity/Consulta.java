package com.ulsa.entity;

import java.sql.Date;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "consulta")
public class Consulta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Nonnull
	private String servicio;
	@Nonnull	
	private Date fecha_atencion;
	@Nonnull
	private float pago;

	@ManyToOne
	@JoinColumn(name = "medico_id")
	private Consulta consulta;

	public Consulta() {}
	

	public Consulta(long id, String servicio, Date fecha_atencion, float pago, Consulta consulta) {
		this.id = id;
		this.servicio = servicio;
		this.fecha_atencion = fecha_atencion;
		this.pago = pago;
		this.consulta = consulta;
	}


	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getServicio() {
		return this.servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public Date getFecha_atencion() {
		return this.fecha_atencion;
	}

	public void setFecha_atencion(Date fecha_atencion) {
		this.fecha_atencion = fecha_atencion;
	}

	public float getPago() {
		return this.pago;
	}

	public void setPago(float pago) {
		this.pago = pago;
	}

	public Consulta getConsulta() {
		return this.consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	

	
	
	
	

}
