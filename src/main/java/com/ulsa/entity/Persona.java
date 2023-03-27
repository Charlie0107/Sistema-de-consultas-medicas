package com.ulsa.entity;

import java.sql.Date;

import javax.annotation.Nonnull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "persona")
public class Persona {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Nonnull
	private String nombre;
	@Nonnull
	private String apePat;
	@Nonnull
	private String apeMat;
	@Nonnull
	private String genero;
    @Nonnull
    private Date fecha_nacimiento;
    @Nonnull
	private String email;
    @Nonnull
	private String direccion;
	@Nonnull
	private String celular;

    @OneToOne(mappedBy = "persona")
    private Medico medico;
    @OneToOne(mappedBy = "persona")
    private Paciente paciente;


    public Persona(long id, String nombre, String apePat, String apeMat, String genero, Date fecha_nacimiento, String email, String direccion, String celular) {
        this.id = id;
        this.nombre = nombre;
        this.apePat = apePat;
        this.apeMat = apeMat;
        this.genero = genero;
        this.fecha_nacimiento = fecha_nacimiento;
        this.email = email;
        this.direccion = direccion;
        this.celular = celular;
    }


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApePat() {
        return this.apePat;
    }

    public void setApePat(String apePat) {
        this.apePat = apePat;
    }

    public String getApeMat() {
        return this.apeMat;
    }

    public void setApeMat(String apeMat) {
        this.apeMat = apeMat;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFecha_nacimiento() {
        return this.fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return this.celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Medico getMedico() {
        return this.medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return this.paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }



	
    
}
