package com.mycompany.odontoweb.Servlets;

import com.mycompany.odontoweb.Logica.Controladora;
import com.mycompany.odontoweb.Logica.Odontologo;
import com.mycompany.odontoweb.Logica.Paciente;
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
@WebServlet(name = "SvAltaTurno", urlPatterns = {"/SvAltaTurno"})
public class SvAltaTurno extends HttpServlet {

    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
