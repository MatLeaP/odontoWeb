package com.mycompany.odontoweb.Servlets;

import com.mycompany.odontoweb.Logica.Controladora;
import com.mycompany.odontoweb.Logica.Paciente;
import com.mycompany.odontoweb.Logica.Turno;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Matias
 */
@WebServlet(name = "SvEstadisticas", urlPatterns = {"/SvEstadisticas"})
public class SvEstadisticas extends HttpServlet {

    
    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Paciente> listaPacientes = control.traerPacientes();
        List<Turno> listaTurnos = control.traerTurnos();
        
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("listaPacientes", listaPacientes);
        miSesion.setAttribute("listaTurnos", listaTurnos);
        
        response.sendRedirect("estadisticas.jsp");
        
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
