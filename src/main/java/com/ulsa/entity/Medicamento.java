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
@Table(name = "medicamento")
public class Medicamento {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Nonnull
    private String nombre;
    @Nonnull
    private String cantidad_contenida;
    @Nonnull
    private Date caducidad;
    @Nonnull
    private String num_serie;
    @Nonnull
    private String laboratorio;

    @ManyToOne
	@JoinColumn(name = "receta_id")
	private Receta receta;
    
    public Medicamento(){
        super();
    }

    public Medicamento(long id, String nombre, String cantidad_contenida, Date caducidad, String num_serie, String laboratorio, Receta receta) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.cantidad_contenida = cantidad_contenida;
        this.caducidad = caducidad;
        this.num_serie = num_serie;
        this.laboratorio = laboratorio;
        this.receta = receta;
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

    public String getCantidad_contenida() {
        return this.cantidad_contenida;
    }

    public void setCantidad_contenida(String cantidad_contenida) {
        this.cantidad_contenida = cantidad_contenida;
    }

    public Date getCaducidad() {
        return this.caducidad;
    }

    public void setCaducidad(Date caducidad) {
        this.caducidad = caducidad;
    }

    public String getNum_serie() {
        return this.num_serie;
    }

    public void setNum_serie(String num_serie) {
        this.num_serie = num_serie;
    }

    public String getLaboratorio() {
        return this.laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Receta getReceta() {
        return this.receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }



    
}
