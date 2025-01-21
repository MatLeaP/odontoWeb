package com.mycompany.odontoweb.Logica;

import com.google.gson.annotations.Expose;
import com.fasterxml.jackson.annotation.JsonIgnore; // Si usas Jackson, puedes optar por esta también
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Horario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose // Incluye este campo en la serialización JSON
    private Long id;

    @Expose // Incluye este campo en la serialización JSON
    private String horarioInicio;

    @Expose // Incluye este campo en la serialización JSON
    private String horarioFin;

    @JsonIgnore // Evita la serialización de esta relación para evitar referencias circulares
    @ManyToMany(mappedBy = "listaHorarios")
    private List<Odontologo> odontologos;

    // Constructores
    public Horario(Long id, String horarioInicio, String horarioFin) {
        this.id = id;
        this.horarioInicio = horarioInicio;
        this.horarioFin = horarioFin;
    }

    public Horario() {
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public String getHorarioFin() {
        return horarioFin;
    }

    public void setHorarioFin(String horarioFin) {
        this.horarioFin = horarioFin;
    }

    public List<Odontologo> getOdontologos() {
        return odontologos;
    }

    public void setOdontologos(List<Odontologo> odontologos) {
        this.odontologos = odontologos;
    }

    @Override
    public String toString() {
        return "Horario{" +
                "id=" + id +
                ", horarioInicio='" + horarioInicio + '\'' +
                ", horarioFin='" + horarioFin + '\'' +
                '}';
    }
}
