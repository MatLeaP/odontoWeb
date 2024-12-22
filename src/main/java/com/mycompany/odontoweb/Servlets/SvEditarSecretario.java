
package com.mycompany.odontoweb.Servlets;

import com.mycompany.odontoweb.Logica.Controladora;
import com.mycompany.odontoweb.Logica.Secretario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvEditarSecretario", urlPatterns = {"/SvEditarSecretario"})
public class SvEditarSecretario extends HttpServlet {

    Controladora control = new Controladora();
    
   

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        Secretario secretario = control.traerSecretario(id);
        
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("secretario", secretario);
        
        response.sendRedirect("editarSecretario.jsp");
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
        String area = request.getParameter("area");
        
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
        
      
        Secretario secretario = (Secretario) request.getSession().getAttribute("secretario");
        
        secretario.setDni(dni);
        secretario.setNombre(nombre);
        secretario.setApellido(apellido);
        secretario.setTelefono(telefono);
        secretario.setDireccion(direccion);
        secretario.setFecha_nac(fecha_nac);
        secretario.setArea(area);
        
        control.editarSecretario(secretario);
        
        response.sendRedirect("SvSecretarios");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
