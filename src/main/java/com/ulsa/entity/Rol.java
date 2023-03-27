package com.ulsa.entity;

import javax.annotation.Nonnull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "rol")
public class Rol {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Nonnull
    private String nombre;
    @Nonnull
    private String descripcion;

    public Rol(){
        super();
    }

    public Rol(long id, String nombre, String descripcion) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Rol(String nombre) {
        super();
        this.nombre = nombre;
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


    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    
}
