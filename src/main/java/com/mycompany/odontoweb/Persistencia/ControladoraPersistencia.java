package com.mycompany.odontoweb.Persistencia;

import com.mycompany.odontoweb.Logica.Usuario;
import com.mycompany.odontoweb.Persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {
    
    //HorarioJpaController horaJpa = new HorarioJpaController();
    //OdontologoJpaController odontologoJpa = new OdontologoJpaController();
    //PacienteJpaController pacienteJpa = new PacienteJpaController();
    //PersonaJpaController personaJpa = new PersonaJpaController();
    //ResponsableJpaController responsableJpa = new ResponsableJpaController();
    //SecretarioJpaController secretarioJpa = new SecretarioJpaController();
    //TurnoJpaController turnoJpa = new TurnoJpaController();
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();

    
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
    
    
}
