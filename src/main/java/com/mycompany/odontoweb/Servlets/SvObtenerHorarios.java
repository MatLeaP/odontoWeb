package com.mycompany.odontoweb.Servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mycompany.odontoweb.Logica.Controladora;
import com.mycompany.odontoweb.Logica.Horario;
import com.mycompany.odontoweb.Logica.Odontologo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SvObtenerHorarios", urlPatterns = {"/SvObtenerHorarios"})
public class SvObtenerHorarios extends HttpServlet {

    Controladora control = new Controladora();
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");

        String odontologoId = request.getParameter("odontologoId");
        
        
        try {
            odontologoId = request.getParameter("odontologoId");
            System.out.println(odontologoId);
        } catch (NumberFormatException e) {
            // Manejar errores de conversión
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"error\": \"Invalid odontologoId\"}");
            return;
        }

        Odontologo odon = control.traerOdontologo(Integer.parseInt(odontologoId));
       
        
        List<Horario> horarios = odon.getListaHorarios();
        List<Horario> nuevosHorarios = new ArrayList<>();
        
        for (Horario idHorario : horarios) {
            Horario horario = control.traerHorario(idHorario.getId());
            nuevosHorarios.add(horario); 
            System.out.println(horario);
        }     
       

        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation() // Excluye campos sin la anotación @Expose
                .create();

        String json = gson.toJson(horarios); // Convierte la lista a formato JSON

// Envía la respuesta JSON al cliente
        response.setContentType("application/json");
        response.getWriter().write(json);
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
