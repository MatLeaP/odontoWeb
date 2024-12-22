package com.mycompany.odontoweb.Logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Horario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Considera usar Long para la clave primaria

    private String horarioInicio;
    private String horarioFin;

   
    @ManyToMany(mappedBy = "listaHorarios")
    private List<Odontologo> odontologos;
    


    public Horario(Long id, String horarioInicio, String horarioFin) {
        this.id = id;
        this.horarioInicio = horarioInicio;
        this.horarioFin = horarioFin;
    }

    public Horario() {
    }

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
