package com.mycompany.odontoweb.Logica;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Turno implements Serializable {
    
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id_turno;
        
    private LocalDate fecha_turno;
    @ManyToOne
    @JoinColumn(name = "hora_turno")
    private Horario hora_turno;
    private String afeccion;    
    @ManyToOne
    @JoinColumn(name="id_odonto")
    private Odontologo odonto;
    @ManyToOne
    @JoinColumn(name="id_paciente")       
    private Paciente pacien;
    
    @OneToOne(mappedBy = "turno", cascade = CascadeType.ALL)
    private Atencion atencion;

    public Turno() {
    }

    public Turno(int id_turno, LocalDate fecha_turno, Horario hora_turno, String afeccion, Odontologo odonto, Paciente pacien) {
        this.id_turno = id_turno;
        this.fecha_turno = fecha_turno;
        this.hora_turno = hora_turno;
        this.afeccion = afeccion;
        this.odonto = odonto;
        this.pacien = pacien;
    }  
    
  

    public int getId_turno() {
        return id_turno;
    }

    public void setId_turno(int id_turno) {
        this.id_turno = id_turno;
    }

    public LocalDate getFecha_turno() {
        return fecha_turno;
    }

    public void setFecha_turno(LocalDate fecha_turno) {
        this.fecha_turno = fecha_turno;
    }

    public Horario getHora_turno() {
        return hora_turno;
    }

    public void setHora_turno(Horario hora_turno) {
        this.hora_turno = hora_turno;
    }

    public String getAfeccion() {
        return afeccion;
    }

    public void setAfeccion(String afeccion) {
        this.afeccion = afeccion;
    }

    public Odontologo getOdonto() {
        return odonto;
    }

    public void setOdonto(Odontologo odonto) {
        this.odonto = odonto;
    }

    public Paciente getPacien() {
        return pacien;
    }

    public void setPacien(Paciente pacien) {
        this.pacien = pacien;
    }
    
    
    public Atencion getAtencion() {
        return atencion;
    }

    public void setAtencion(Atencion atencion) {
        this.atencion = atencion;
    }
    

    
}
