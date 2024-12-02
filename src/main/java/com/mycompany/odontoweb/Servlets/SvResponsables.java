package com.mycompany.odontoweb.Servlets;

import com.mycompany.odontoweb.Logica.Controladora;
import com.mycompany.odontoweb.Logica.Responsable;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

@WebServlet(name = "SvResponsables", urlPatterns = {"/SvResponsables"})
public class SvResponsables extends HttpServlet {

    
    Controladora control = new Controladora();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List <Responsable> responsables = new ArrayList <Responsable>();
        
        responsables = control.traerResponsables();
        
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("listaResponsables", responsables);
        
        response.sendRedirect("verResponsables.jsp");
        
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
        String tipo_responsable = request.getParameter("tipo_responsable");
        
        Date fecha_nac = null;
        if (fechanacStr != null && !fechanacStr.isEmpty()) {
            try {
                fecha_nac = new SimpleDateFormat("yyyy-MM-dd").parse(fechanacStr);
            } catch (ParseException ex) {
                Logger.getLogger(SvOdontologos.class.getName()).log(Level.SEVERE, "Error al parsear la fecha", ex);
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Fecha de nacimiento inválida");
                return;
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "El campo de fecha de nacimiento está vacío");
            return;
        }
        
        
        control.crearResponsable(dni, nombre, apellido, telefono, direccion, fecha_nac, tipo_responsable);
        
        response.sendRedirect("index.jsp");
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
