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
	@Nonnull
	private String alergias;	

	@OneToOne
	@JoinColumn(name = "persona_id")
	private Persona persona;
	
	public Paciente() {	
		super();
	}




	public Paciente(long id, String peso, String altura, String temperatura, String presion, String alergias, Persona persona) {
		super();
		this.id = id;
		this.peso = peso;
		this.altura = altura;
		this.temperatura = temperatura;
		this.presion = presion;
		this.alergias = alergias;
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

	public String getAlergias() {
		return this.alergias;
	}

	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}


	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}


}
