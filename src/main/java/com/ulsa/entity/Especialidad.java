package com.ulsa.entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "especialidad")
public class Especialidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Nonnull
	private String nombreEspecialidad;

	@OneToMany
	@JoinColumn(name = "especialidad_id")
	private List<Medico> listamedicos = new ArrayList<>();
	
	
	public Especialidad() {
		super();
	}


	public Especialidad(long id, String nombreEspecialidad, List<Medico> listamedicos) {
		super();
		this.id = id;
		this.nombreEspecialidad = nombreEspecialidad;
		this.listamedicos = listamedicos;
	}

	public Especialidad(String nombreEspecialidad, List<Medico> listamedicos) {
		super();
		this.nombreEspecialidad = nombreEspecialidad;
		this.listamedicos = listamedicos;
	}

	public Especialidad(long id) {
		super();
		this.id = id;
	}
	
		

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreEspecialidad() {
		return nombreEspecialidad;
	}

	public void setNombreEspecialidad(String nombreEspecialidad) {
		this.nombreEspecialidad = nombreEspecialidad;
	}
	

	public List<Medico> getListamedicos() {
		return this.listamedicos;
	}

	public void setListamedicos(List<Medico> listamedicos) {
		this.listamedicos = listamedicos;
	}
	


	@Override
	public String toString() {
		return "{" +
			"nombreEspecialidad='" + getNombreEspecialidad() + "'" +
			", listamedicos='" + getListamedicos() + "'" +
			"}";
	}
	


	

}
