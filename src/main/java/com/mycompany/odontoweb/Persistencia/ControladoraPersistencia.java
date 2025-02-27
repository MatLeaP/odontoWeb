package com.mycompany.odontoweb.Persistencia;

import com.mycompany.odontoweb.Logica.Horario;
import com.mycompany.odontoweb.Logica.Odontologo;
import com.mycompany.odontoweb.Logica.Paciente;
import com.mycompany.odontoweb.Logica.Responsable;
import com.mycompany.odontoweb.Logica.Secretario;
import com.mycompany.odontoweb.Logica.Turno;
import com.mycompany.odontoweb.Logica.Usuario;
import com.mycompany.odontoweb.Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {
    
    HorarioJpaController horaJpa = new HorarioJpaController();
    OdontologoJpaController odontologoJpa = new OdontologoJpaController();
    PacienteJpaController pacienteJpa = new PacienteJpaController();
    //PersonaJpaController personaJpa = new PersonaJpaController();
    ResponsableJpaController responsableJpa = new ResponsableJpaController();
    SecretarioJpaController secretarioJpa = new SecretarioJpaController();
    TurnoJpaController turnoJpa = new TurnoJpaController();
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();
    AtencionJpaController atencionJpa = new AtencionJpaController();

    
    /*public ControladoraPersistencia(){
        
    }
    */
    public void crearUsuario(Usuario usu) {
        
        usuarioJpa.create(usu);
        
    }

    public List<Usuario> traerUsuarios() {
        return usuarioJpa.findUsuarioEntities() ;
    }

    public void eliminarUsuario(int id) {
        try {
            usuarioJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario traerUsuario(int id) {
        
        return usuarioJpa.findUsuario(id);
    }

    public void editarUsuario(Usuario usu) {
        
        try {
            usuarioJpa.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearOdontologo(Odontologo odon) {
        
        odontologoJpa.create(odon);
    }

    public List<Odontologo> traerOdontologos() {
        
        return odontologoJpa.findOdontologoEntities();
    }

    public void eliminarOdontologo(int id) {
        
        try {
            odontologoJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Odontologo traerOdontologo(int id) {
        
        return odontologoJpa.findOdontologo(id);
    }

    public void editarOdontologo(Odontologo odon) {
        
        try {
            odontologoJpa.edit(odon);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearPaciente(Paciente paciente) {
        
        pacienteJpa.create(paciente);
    }

    public List<Paciente> traerPacientes() {
        
        return pacienteJpa.findPacienteEntities();
    }

    public void eliminarPaciente(int id) {
        
        try {
            pacienteJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Paciente traerPaciente(int id) {
        return pacienteJpa.findPaciente(id);
    }

    public void editarPaciente(Paciente pacien) {
        
        try {
            pacienteJpa.edit(pacien);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearHorario(Horario horario) {
        
        horaJpa.create(horario);
        
    }

    public List<Horario> traerHorarios() {
        
        return horaJpa.findHorarioEntities();
    }

    public void eliminarHorario(int id) {
        
        try {
            horaJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void crearResponsable(Responsable resp) {
        
        responsableJpa.create(resp);
    }

    public List<Responsable> traerResponsables() {
        
        return responsableJpa.findResponsableEntities();
    }

    public void eliminarResponsable(int id) {
        
        try {
            responsableJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Responsable traerResponsable(int id) {
        
        return responsableJpa.findResponsable(id);
    }

    public void editarResponsable(Responsable responsable) {
        
        try {
            responsableJpa.edit(responsable);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Horario traerHorario(Long id) {
        
        return horaJpa.findHorario(id);
    }

    public void crearSecretario(Secretario secre) {
        
        secretarioJpa.create(secre);
    }

     public void eliminarSecretario(int id) {
         
        try {
            secretarioJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Secretario> traerSecretarios() {
    
        return secretarioJpa.findSecretarioEntities();
    }

    public Secretario traerSecretario(int id) {
        
        return secretarioJpa.findSecretario(id);
    }

    public void editarSecretario(Secretario secretario) {
        
        try {
            secretarioJpa.edit(secretario);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearTurno(Turno turno) {
        
        turnoJpa.create(turno);
    }

    public List<Turno> traerTurnos() {
        
        return turnoJpa.findTurnoEntities();
    }

    public void eliminarTurno(int id) {
        
        try {
            turnoJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   

    

    

    

      
}
