package com.ulsa.entity;

import javax.annotation.Nonnull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pacientes")
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Nonnull
	private String peso;
	@Nonnull
	private String altura;
	@Nonnull
	private String temperatura;
	@Nonnull
	private String presion;	

	@OneToOne
	@JoinColumn(name = "persona_id")
	private Persona persona;
	
	public Paciente() {	}



	public Paciente(long id, String peso, String altura, String temperatura, String presion, Persona persona) {
		this.id = id;
		this.peso = peso;
		this.altura = altura;
		this.temperatura = temperatura;
		this.presion = presion;
		this.persona = persona;
	}



	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPeso() {
		return this.peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getAltura() {
		return this.altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getTemperatura() {
		return this.temperatura;
	}

	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}

	public String getPresion() {
		return this.presion;
	}

	public void setPresion(String presion) {
		this.presion = presion;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}


}
