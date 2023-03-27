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
@Table(name = "receta")
public class Receta {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
    private long id;
    @Nonnull
    private String diagnostico;
    @Nonnull 
    private String duracion_tratamiento;
    @Nonnull
    private String farmaco;
    @Nonnull
    private int unidades;
    @Nonnull
    private String Indicaciones;

    @OneToMany
	@JoinColumn(name = "receta_id")
	private List<Medicamento> medicamento = new ArrayList<>();


    public Receta(long id, String diagnostico, String duracion_tratamiento, String farmaco, int unidades, String Indicaciones) {
        this.id = id;
        this.diagnostico = diagnostico;
        this.duracion_tratamiento = duracion_tratamiento;
        this.farmaco = farmaco;
        this.unidades = unidades;
        this.Indicaciones = Indicaciones;
    }



    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDiagnostico() {
        return this.diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getDuracion_tratamiento() {
        return this.duracion_tratamiento;
    }

    public void setDuracion_tratamiento(String duracion_tratamiento) {
        this.duracion_tratamiento = duracion_tratamiento;
    }

    public String getFarmaco() {
        return this.farmaco;
    }

    public void setFarmaco(String farmaco) {
        this.farmaco = farmaco;
    }

    public int getUnidades() {
        return this.unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public String getIndicaciones() {
        return this.Indicaciones;
    }

    public void setIndicaciones(String Indicaciones) {
        this.Indicaciones = Indicaciones;
    }

    
}
