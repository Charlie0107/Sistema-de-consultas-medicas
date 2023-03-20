package com.ulsa.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "medico")
public class Medico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Nonnull
	private String cedula;
	
	@ManyToOne
	@JoinColumn(name = "especialidad_id")
	private Especialidad especialidad;

	@OneToOne
	@JoinColumn(name = "persona_id")
	private Persona persona;

	
	public Medico(){
		
	}


	public Medico(long id, String cedula, Especialidad especialidad, Persona persona) {
		this.id = id;
		this.cedula = cedula;
		this.especialidad = especialidad;
		this.persona = persona;
	}



	/* 
	public Medico(long id, String cedula, String nombre, String apePat, String apeMat, String genero, String celular,
			String email) {
		super();
		this.id = id;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apePat = apePat;
		this.apeMat = apeMat;
		this.genero = genero;
		this.celular = celular;
		this.email = email;
	}
	*/

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public Especialidad getEspecialidad() {
		return this.especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	
	

}
