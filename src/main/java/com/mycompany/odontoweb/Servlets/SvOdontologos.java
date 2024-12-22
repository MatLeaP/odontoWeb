package com.mycompany.odontoweb.Servlets;

import com.mycompany.odontoweb.Logica.Controladora;
import com.mycompany.odontoweb.Logica.Odontologo;
import java.io.IOException;
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


@WebServlet(name = "SvOdontologos", urlPatterns = {"/SvOdontologos"})
public class SvOdontologos extends HttpServlet {

    Controladora control = new Controladora();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Odontologo> listaOdontologos = new ArrayList <Odontologo>();
        listaOdontologos = control.traerOdontologos();
        
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("listaOdontologos", listaOdontologos);
        
        response.sendRedirect("verOdontologos.jsp");
        
        for (Odontologo odontologo : listaOdontologos) {
            System.out.println("Horarios del odontólogo " + odontologo.getNombre() + ": " + odontologo.getListaHorarios());
}
        
    }

 
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String especialidad = request.getParameter("especialidad");
        String fechanacStr = request.getParameter("fechanac");
        String usuario = request.getParameter("usuario");
        String[] horariosSeleccionados = request.getParameterValues("horario[]");

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
        
        
        if (horariosSeleccionados == null || horariosSeleccionados.length == 0) {
            System.out.println("No se recibieron horarios seleccionados");
        } else {
            for (String horario : horariosSeleccionados) {
                System.out.println("Horario seleccionado: " + horario );
            }
        }
        
        
        List<Long> listaIdsHorarios = new ArrayList<>();
            if (horariosSeleccionados != null) {
                for (String idHorario : horariosSeleccionados) {
                listaIdsHorarios.add(Long.parseLong(idHorario));
        }
    }

        // Llamada a la controladora con los datos preparados
        control.crearOdontologo(dni, nombre, apellido, telefono, direccion, fecha_nac, especialidad, usuario, listaIdsHorarios);

        // Redirigir al índice u otra página
        response.sendRedirect("index.jsp");
    }


    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
