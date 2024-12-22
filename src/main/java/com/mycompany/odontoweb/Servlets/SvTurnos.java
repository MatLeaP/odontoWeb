package com.mycompany.odontoweb.Servlets;

import com.mycompany.odontoweb.Logica.Controladora;
import com.mycompany.odontoweb.Logica.Odontologo;
import com.mycompany.odontoweb.Logica.Paciente;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvTurnos", urlPatterns = {"/SvTurnos"})
public class SvTurnos extends HttpServlet {

    
    Controladora control = new Controladora();
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
     
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Paciente> listaPacientes =control.traerPacientes();
        List<Odontologo> listaOdontologos =control.traerOdontologos();
        
        
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("listaPacientes", listaPacientes);
        miSesion.setAttribute("listaOdontologos", listaOdontologos);
        
        response.sendRedirect("altaTurno.jsp");
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String fechaTurnoStr = request.getParameter("fecha_turno");
        String hora_turno = request.getParameter("hora_turno");
        String afeccion = request.getParameter("afeccion");
        String odontologo = request.getParameter("odontologo");
        String paciente = request.getParameter("paciente");
        
        LocalDate fecha_turno = null;
        if (fechaTurnoStr != null && !fechaTurnoStr.isEmpty()) {
            try {
                fecha_turno = LocalDate.parse(fechaTurnoStr); // Formato: yyyy-MM-dd
            } catch (DateTimeParseException ex) {
                Logger.getLogger(SvTurnos.class.getName()).log(Level.SEVERE, "Error al parsear la fecha", ex);
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Fecha del turno inválida");
                return;
            }
        }

        
        control.crearTurno(fecha_turno, hora_turno, afeccion, odontologo, paciente);
        
        response.sendRedirect("index.jsp");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
