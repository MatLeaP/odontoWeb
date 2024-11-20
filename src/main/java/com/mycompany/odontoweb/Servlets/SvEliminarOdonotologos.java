
package com.mycompany.odontoweb.Servlets;

import com.mycompany.odontoweb.Logica.Controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SvEliminarOdonotologos", urlPatterns = {"/SvEliminarOdonotologos"})
public class SvEliminarOdonotologos extends HttpServlet {

    Controladora control = new Controladora();
    
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id")); 
        
        control.eliminarOdontologo(id);
        response.sendRedirect("verOdontologos.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
