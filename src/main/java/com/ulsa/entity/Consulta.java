package com.ulsa.entity;

import java.sql.Date;

import javax.annotation.Nonnull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	private Medico medico;

	public Consulta() {
		super();
	}
	

	public Consulta(long id, String servicio, Date fecha_atencion, float pago, Medico medico) {
		super();
		this.id = id;
		this.servicio = servicio;
		this.fecha_atencion = fecha_atencion;
		this.pago = pago;
		this.medico = medico;
	}

	public Consulta(String servicio, Date fecha_atencion, float pago, Medico medico) {
		super();
		this.servicio = servicio;
		this.fecha_atencion = fecha_atencion;
		this.pago = pago;
		this.medico = medico;
	}

	public Consulta(String servicio) {
		super();
		this.servicio = servicio;

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

	public Medico getMedico() {
		return this.medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	

	
	
	
	

}
