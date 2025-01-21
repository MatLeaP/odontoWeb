package com.mycompany.odontoweb.Logica;

import com.mycompany.odontoweb.Persistencia.ControladoraPersistencia;
import java.time.LocalDate;
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

    public void crearOdontologo(String dni, String nombre, String apellido, String telefono, String direccion, LocalDate fecha_nac, String especialidad, String usuario, List<Long> listaIdsHorarios) {
        
        Odontologo odon = new Odontologo();
        odon.setDni(dni);
        odon.setNombre(nombre);
        odon.setApellido(apellido);
        odon.setTelefono(telefono);
        odon.setDireccion(direccion);
        odon.setFecha_nac(fecha_nac);
        odon.setEspecialidad(especialidad);
        
        Usuario unUsuario = controlPersis.traerUsuario(Integer.parseInt(usuario));
        odon.setunUsuario(unUsuario);
        
        List<Horario> horarios = new ArrayList<>();
        for (Long idHorario : listaIdsHorarios) {
            Horario horario = controlPersis.traerHorario(idHorario);
            horarios.add(horario);
        }
        odon.setListaHorarios(horarios);
        
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

    
    public void crearPaciente(String dni, String nombre, String apellido, String telefono, String direccion, LocalDate fecha_nac, String os, String tipo_sangre, String responsable) {
        
        Paciente paciente = new Paciente();
        paciente.setDni(dni);
        paciente.setNombre(nombre);
        paciente.setApellido(apellido);
        paciente.setTelefono(telefono);
        paciente.setDireccion(direccion);
        paciente.setFecha_nac(fecha_nac);
        paciente.setTiene_os(os);
        paciente.setTipo_sangre(tipo_sangre);
        
        Responsable resp = controlPersis.traerResponsable(Integer.parseInt(responsable) );
        paciente.setResponsable(resp);
        
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

    public void editarPaciente(Paciente pacien) {
        
        controlPersis.editarPaciente(pacien);
    }

    public void crearHorario(String horarioInicio, String horarioFin) {
        
        Horario horario = new Horario();
        
        horario.setHorarioInicio(horarioInicio);
        horario.setHorarioFin(horarioFin);
        
        
        controlPersis.crearHorario(horario);
    }

    public List<Horario> traerHorarios() {
        
        return controlPersis.traerHorarios();
    }
    
    
    public void eliminarHorario(int id) {
        
        controlPersis.eliminarHorario(id);
        
    }

    public void crearResponsable(String dni, String nombre, String apellido, String telefono, String direccion, LocalDate fecha_nac, String tipo_responsable) {
        
        Responsable resp = new Responsable();
        
        resp.setDni(dni);
        resp.setNombre(nombre);
        resp.setDireccion(direccion);
        resp.setApellido(apellido);
        resp.setTelefono(telefono);
        resp.setFecha_nac(fecha_nac);
        resp.setTipo_responsable(tipo_responsable);
        
        controlPersis.crearResponsable(resp);
    }

    public List<Responsable> traerResponsables() {
        
        return controlPersis.traerResponsables();
    }

    public void eliminarResponsable(int id) {
        
        controlPersis.eliminarResponsable(id);
    }

    public Responsable traerResponsable(int id) {
        
        return controlPersis.traerResponsable(id);
    }

    public void editarResponsable(Responsable responsable) {
        
        controlPersis.editarResponsable(responsable);
    }

    public Horario traerHorario(Long id) {
        
        return controlPersis.traerHorario(id);
    }

    public void crearSecretario(String dni, String nombre, String apellido, String telefono, String direccion, LocalDate fecha_nac, String area) {
        
        Secretario secre = new Secretario();
        
        secre.setDni(dni);
        secre.setNombre(nombre);
        secre.setApellido(apellido);
        secre.setTelefono(telefono);
        secre.setDireccion(direccion);
        secre.setFecha_nac(fecha_nac);
        secre.setArea(area);
             
        controlPersis.crearSecretario(secre);
    }

    public List<Secretario> traerSecretarios() {
        
        return controlPersis.traerSecretarios();
        
    }

    public void eliminarSecretario(int id) {
        
        controlPersis.eliminarSecretario(id);
    }

    public Secretario traerSecretario(int id) {
        
        return controlPersis.traerSecretario(id);
    }

    public void editarSecretario(Secretario secretario) {
        
        controlPersis.editarSecretario(secretario);
    }
    
    public void crearTurno(LocalDate fecha_turno, String hora_turno, String afeccion, String odontologo, String paciente) {
        
        Turno turno = new Turno();
        
        turno.setFecha_turno(fecha_turno);
        
        Horario hora = controlPersis.traerHorario(Long.parseLong(hora_turno));
        turno.setHora_turno(hora);
        turno.setAfeccion(afeccion);
        
        Odontologo odon = controlPersis.traerOdontologo(Integer.parseInt(odontologo));        
        turno.setOdonto(odon);
        
        Paciente pacien = controlPersis.traerPaciente(Integer.parseInt(paciente));
        turno.setPacien(pacien);
        
        controlPersis.crearTurno(turno);
    }


    public List<Horario> traerOdontologoPorHorario(int odontologoId) {
        
        Odontologo odonto = controlPersis.traerOdontologo(odontologoId);
        
        
        
        List<Horario> horarios = odonto.getListaHorarios();
        
        for (Horario idHorario : horarios) {
            Horario horario;
            horario = controlPersis.traerHorario(idHorario.getId());
            horarios.add(horario);
        }               
        
        
        return odonto.getListaHorarios() ;
    }

    public List<Turno> traerTurnos() {
        
        return controlPersis.traerTurnos();
    }

    public void eliminarTurno(int id) {
        
        controlPersis.eliminarTurno(id);
    }

    

  

   

    
    

   

    

   
}


