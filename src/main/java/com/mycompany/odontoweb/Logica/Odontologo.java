package com.mycompany.odontoweb.Logica;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Odontologo extends Persona implements Serializable{
    
    //private int id_odontologo;
    private String especialidad;    
    @OneToMany(mappedBy = "odonto") 
    private List<Turno> listaTurnos;    
    @OneToOne
    private Usuario unUsuario;    
    @ManyToMany
    @JoinTable(
            name = "odontologo_horario", // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "odontologo_id"), // Clave foránea hacia Odontologo
            inverseJoinColumns = @JoinColumn(name = "listahorarios_id") // Clave foránea hacia Horario
    )
    private List<Horario> listaHorarios;

    
    public Odontologo() {
    }

    public Odontologo(String especialidad, List<Turno> listaTurnos, Usuario unUsuario,List<Horario>  listaHorarios, int id, String dni, String nombre, String apellido, String telefono, String direccion, LocalDate fecha_nac) {
        super(id, dni, nombre, apellido, telefono, direccion, fecha_nac);
        this.especialidad = especialidad;
        this.listaTurnos = listaTurnos;
        this.unUsuario = unUsuario;
        this.listaHorarios = listaHorarios;
    }
 
   
    /*
    public int getId_odontologo() {
        return id_odontologo;
    }

    public void setId_odontologo(int id_odontologo) {
        this.id_odontologo = id_odontologo;
    }
*/
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Turno> getListaTurnos() {
        return listaTurnos;
    }

    public void setListaTurnos(List<Turno> listaTurnos) {
        this.listaTurnos = listaTurnos;
    }

    public Usuario getunUsuario() {
        return unUsuario;
    }

    public void setunUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }

    public List<Horario> getListaHorarios() {
        return listaHorarios;
    }

    public void setListaHorarios(List<Horario> listaHorarios) {
        this.listaHorarios = listaHorarios;
    }
    
    
}
