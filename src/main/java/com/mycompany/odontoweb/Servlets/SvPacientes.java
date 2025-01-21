package com.mycompany.odontoweb.Servlets;

import com.mycompany.odontoweb.Logica.Controladora;
import com.mycompany.odontoweb.Logica.Paciente;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvPacientes", urlPatterns = {"/SvPacientes"})
public class SvPacientes extends HttpServlet {

    Controladora control = new Controladora();
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List <Paciente> listaPacientes = new ArrayList <Paciente>();
        listaPacientes = control.traerPacientes();
        
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("listaPacientes", listaPacientes);
        
        response.sendRedirect("verPacientes.jsp");
    }

   
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");        
        String fechanacStr = request.getParameter("fechanac");
        String os = request.getParameter("os");
        String tipo_sangre = request.getParameter("tipo_sangre");
        String responsable = request.getParameter("responsable");
  
        LocalDate fecha_nac = null;
        if (fechanacStr != null && !fechanacStr.isEmpty()) {
            try {
                fecha_nac = LocalDate.parse(fechanacStr); // Formato por defecto: yyyy-MM-dd
            } catch (DateTimeParseException ex) {
                Logger.getLogger(SvOdontologos.class.getName()).log(Level.SEVERE, "Error al parsear la fecha", ex);
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Fecha de nacimiento inválida");
                return;
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "El campo de fecha de nacimiento está vacío");
            return;
        }
        
        control.crearPaciente(dni, nombre, apellido, telefono, direccion, fecha_nac,os, tipo_sangre, responsable);
        
        response.sendRedirect("index.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
