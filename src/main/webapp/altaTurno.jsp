<%@page import="com.mycompany.odontoweb.Logica.Paciente"%>
<%@page import="com.mycompany.odontoweb.Logica.Odontologo"%>
<%@page import="java.util.List"%>
<html >
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@include file="components/header.jsp" %>
    <%@include file="components/bodySup.jsp" %>

    <h1>Alta secretarios</h1>
    <form class="user" action="SvTurnos" method="POST">
        <div class="form-group col">
            <div class="col-sm-6 mb-3">
                <input type="date" class="form-control form-control-user" id="fecha_turno" name="fecha_turno"
                       placeholder="Fecha">
            </div>
            <div class="col-sm-6 mb-3">
                <input type="text" class="form-control form-control-user" id="hora_turno" name="hora_turno"
                       placeholder="Horario">
            </div>
            <div class="col-sm-6 mb-3">
                <input type="text" class="form-control form-control-user" id="afeccion" name="afeccion"
                       placeholder="Afeccion">
            </div>
            <% List <Odontologo> listaOdontologos = (List) request.getSession().getAttribute("listaOdontologos");
                                    %>
                <div class="col-sm-6 mb-3">
                    <label for="odontologo">Seleccione un Odontólogo:</label>
                        <select class="form-control" id="odontologo" name="odontologo" required>
                            <option value="" disabled selected>Seleccione un odontólogo</option>
                            <% if (listaOdontologos != null) { %>
                            <% for (Odontologo odonto : listaOdontologos) {%>
                            <option value="<%= odonto.getId()%>">
                            <%= odonto.getNombre()%> <%= odonto.getApellido()%>
                            </option>
                            <% } %>
                            <% } else { %>
                            <option value="" disabled>No hay odontólogos disponibles</option>
                            <% } %>
                        </select>
                </div>                    
            <% List <Paciente> listaPacientes = (List) request.getSession().getAttribute("listaPacientes");
                                    %>                        
             <div class="col-sm-6 mb-3">
                 <label for="paciente">Seleccione un Paciente:</label>
                 <select class="form-control" id="paciente" name="paciente" required>
                     <option value="" disabled selected>Seleccione un paciente</option>
                     <%
                         if (listaPacientes != null) {
                             for (Paciente paciente : listaPacientes) {
                     %>
                     <option value="<%= paciente.getId()%>">
                         <%= paciente.getNombre()%> <%= paciente.getApellido()%>
                     </option>
                     <%
                         }
                     } else {
                     %>
                     <option value="" disabled>No hay pacientes disponibles</option>
                     <%
                         }
                     %>
                 </select>
            </div> 
        </div>
        
        <button  class="btn btn-primary btn-user btn-block" type = "submit" >
           Generar turno
        </button>
        
       
        <hr>
    
    </form>

    <%@include file="components/bodyInf.jsp" %>