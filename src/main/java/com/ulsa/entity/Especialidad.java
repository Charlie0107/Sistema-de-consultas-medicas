package com.ulsa.entity;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


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
