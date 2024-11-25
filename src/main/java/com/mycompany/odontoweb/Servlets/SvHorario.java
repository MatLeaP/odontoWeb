package com.mycompany.odontoweb.Servlets;

import com.mycompany.odontoweb.Logica.Controladora;
import com.mycompany.odontoweb.Logica.DiaSemana;
import com.mycompany.odontoweb.Logica.Horario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvHorario", urlPatterns = {"/SvHorario"})
public class SvHorario extends HttpServlet {

    Controladora control = new Controladora();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List <Horario> listaHorarios = new ArrayList <Horario>();
        listaHorarios = control.traerHorarios();
        
        List<DiaSemana> listaDias = Arrays.asList(DiaSemana.values());

        
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("listaHorarios", listaHorarios);
        miSesion.setAttribute("listaDias", listaDias);
        
        response.sendRedirect("verTurnos.jsp");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String horarioInicio = request.getParameter("horario_inicio");
        String horarioFin = request.getParameter("horario_fin");
                        
        control.crearHorario(horarioInicio, horarioFin);
        
        response.sendRedirect("index.jsp");
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
