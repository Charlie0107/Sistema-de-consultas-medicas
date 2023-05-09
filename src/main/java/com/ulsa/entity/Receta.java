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
    private String indicaciones;

    @OneToMany
	@JoinColumn(name = "receta_id")
	private List<Medicamento> medicamento = new ArrayList<>();

    public Receta(){
        super();
    }


    public Receta(long id, String diagnostico, String duracion_tratamiento, String farmaco, int unidades, String indicaciones, List<Medicamento> medicamento) {
        super();
        this.id = id;
        this.diagnostico = diagnostico;
        this.duracion_tratamiento = duracion_tratamiento;
        this.farmaco = farmaco;
        this.unidades = unidades;
        this.indicaciones = indicaciones;
        this.medicamento = medicamento;
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
        return this.indicaciones;
    }

    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }

    public List<Medicamento> getMedicamento() {
        return this.medicamento;
    }

    public void setMedicamento(List<Medicamento> medicamento) {
        this.medicamento = medicamento;
    }


    
}
