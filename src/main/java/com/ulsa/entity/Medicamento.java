package com.ulsa.entity;

import javax.annotation.Nonnull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "medicamento")
public class Medicamento {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Nonnull
    private String nombre;

    @ManyToOne
	@JoinColumn(name = "receta_id")
	private Receta receta;
    

    public Medicamento(long id, String nombre) {
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
