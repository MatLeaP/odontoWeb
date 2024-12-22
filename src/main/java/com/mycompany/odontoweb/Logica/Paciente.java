package com.mycompany.odontoweb.Logica;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;    
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Paciente extends Persona implements Serializable{
    
    //private int id_paciente;
    private String tiene_os;
    private String tipo_sangre;
    @OneToOne
    private Responsable responsable;
    @OneToMany(mappedBy="pacien")
    private List<Turno> listaTurnos;

    
    public Paciente() {
    }

    public Paciente(String tiene_os, String tipo_sangre, Responsable responsable, List<Turno> listaTurnos, int id, String dni, String nombre, String apellido, String telefono, String direccion, LocalDate fecha_nac) {
        super(id, dni, nombre, apellido, telefono, direccion, fecha_nac);
        this.tiene_os = tiene_os;
        this.tipo_sangre = tipo_sangre;
        this.responsable = responsable;
        this.listaTurnos = listaTurnos;
    }

    


    /*
    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }*/

    public String getTiene_os() {
        return tiene_os;
    }

    public void setTiene_os(String tiene_os) {
        this.tiene_os = tiene_os;
    }

    public String getTipo_sangre() {
        return tipo_sangre;
    }

    public void setTipo_sangre(String tipo_sangre) {
        this.tipo_sangre = tipo_sangre;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    public List<Turno> getListaTurnos() {
        return listaTurnos;
    }

    public void setListaTurnos(List<Turno> listaTurnos) {
        this.listaTurnos = listaTurnos;
    }
    
    
    
    
}
