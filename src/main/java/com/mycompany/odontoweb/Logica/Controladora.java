package com.mycompany.odontoweb.Logica;

import com.mycompany.odontoweb.Persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void crearUsuario(String nombreUsuario, String contrasenia, String rol){
        
        Usuario usu = new Usuario();
        usu.setNombre_usuario(nombreUsuario);
        usu.setContraseña(contrasenia);
        usu.setRol(rol);
        
        controlPersis.crearUsuario(usu);
    }

    public List<Usuario> traerUsuarios() {
        return controlPersis.traerUsuarios();
    }

    public void eliminarUsuario(int id) {
        controlPersis.eliminarUsuario(id);
    }

    public Usuario traerUsuario(int id) {
        return controlPersis.traerUsuario(id);
    }

    public void editarUsuario(Usuario usu) {
        
        controlPersis.editarUsuario(usu);
    }

    public boolean comprobarIngreso(String usuario, String contrasenia) {
        
        boolean ingreso = false;
        
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        listaUsuarios = controlPersis.traerUsuarios();
        
        for (Usuario usu : listaUsuarios){
            if(usu.getNombre_usuario().equals(usuario)){
                if(usu.getContraseña().equals(contrasenia)){
                    ingreso = true;
                }else{
                    ingreso = false;
                }
                
            }
        }
        return ingreso;     
    }

    public void crearOdontologo(String dni, String nombre, String apellido, String telefono, String direccion, Date fecha_nac, String especialidad) {
        
        Odontologo odon = new Odontologo();
        odon.setDni(dni);
        odon.setNombre(nombre);
        odon.setApellido(apellido);
        odon.setTelefono(telefono);
        odon.setDireccion(direccion);
        odon.setFecha_nac(fecha_nac);
        odon.setEspecialidad(especialidad);
        
        controlPersis.crearOdontologo(odon);
        
    }

    public List<Odontologo> traerOdontologos() {
        
        return controlPersis.traerOdontologos();
    }

    public void eliminarOdontologo(int id) {
        
        controlPersis.eliminarOdontologo(id);
    }

    public Odontologo traerOdontologo(int id) {
        return controlPersis.traerOdontologo(id);
    }

    public void editarOdontologo(Odontologo odon) {
        controlPersis.editarOdontologo(odon);
    }

    public void crearPaciente(String dni, String nombre, String apellido, String telefono, String direccion, Date fecha_nac, String os, String tipo_sangre) {
        
        Paciente paciente = new Paciente();
        paciente.setDni(dni);
        paciente.setNombre(nombre);
        paciente.setApellido(apellido);
        paciente.setTelefono(telefono);
        paciente.setDireccion(direccion);
        paciente.setFecha_nac(fecha_nac);
        paciente.setTiene_os(os);
        paciente.setTipo_sangre(tipo_sangre);
        
        controlPersis.crearPaciente(paciente);
    }

    public List<Paciente> traerPacientes() {
        return controlPersis.traerPacientes();
        
    }

    

    public void eliminarPaciente(int id) {
        
        controlPersis.eliminarPaciente(id);
    }

    public Paciente traerPaciente(int id) {
        
        return controlPersis.traerPaciente(id);
    }

   

    

   
}


