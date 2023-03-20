package com.ulsa.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "rol")
public class Rol {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Nonnull
    private String nombre;


    public Rol(long id, String nombre) {
        this.id = id;
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

    
}
