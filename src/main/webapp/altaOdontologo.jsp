<%@page import="com.mycompany.odontoweb.Logica.Usuario"%>
<%@page import="com.mycompany.odontoweb.Logica.Horario"%>
<%@page import="java.util.List"%>
<html >
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@include file="components/header.jsp" %>
    <%@include file="components/bodySup.jsp" %>

    <h1>Alta Odontologos</h1>
    <form class="user" action="SvOdontologos" method="POST" accept-charset="UTF-8">
        <div class="form-group col">
            <div class="col-sm-6 mb-3">
                <input type="text" class="form-control form-control-user" id="dni" name="dni"
                       placeholder="DNI">
            </div>
            <div class="col-sm-6 mb-3">
                <input type="text" class="form-control form-control-user" id="nombre" name="nombre"
                       placeholder="Nombre">
            </div>
            <div class="col-sm-6 mb-3">
                <input type="text" class="form-control form-control-user" id="apellido" name="apellido"
                       placeholder="Apellido">
            </div>
            <div class="col-sm-6 mb-3">
                <input type="text" class="form-control form-control-user" id="telefono" name="telefono"
                       placeholder="Telefono">
            </div>
            <div class="col-sm-6 mb-3">
                <input type="text" class="form-control form-control-user" id="direccion" name="direccion"
                       placeholder="Direccion">
            </div>
            <div class="col-sm-6 mb-3">
                <input type="date" class="form-control form-control-user" id="fechanac" name="fechanac"
                       placeholder="Fecha de nacimiento" required>
            </div>
            <div class="col-sm-6 mb-3">
                <input type="text" class="form-control form-control-user" id="especialidad" name="especialidad"
                       placeholder="Especialidad">
            </div>
            <% List<Horario> listaHorarios = (List) request.getSession().getAttribute("listaHorarios"); %>
            <div class="col-sm-6 mb-3">
                <label for="horario">Seleccione los horarios de atención:</label>
                <select class="form-control" id="horario" name="horario[]" multiple required>
                    <% if (listaHorarios != null) { %>
                    <% for (Horario horario : listaHorarios) {%>
                    <option value="<%= horario.getId() %>">
                        <%= horario.getHorarioInicio() %> - <%= horario.getHorarioFin()%>
                    </option>
                    <% } %>
                    <% } else { %>
                    <option value="" disabled>No hay horarios disponibles</option>
                    <% } %>
                </select>
                <small class="form-text text-muted">Mantenga presionada la tecla CTRL (Windows) o CMD (Mac) para seleccionar múltiples opciones.</small>
            </div> 
             <% List <Usuario> listaUsuarios = (List) request.getSession().getAttribute("listaUsuarios");
                                    %>
                <div class="col-sm-6 mb-3">
                    <label for="usuario">Seleccione un usuario:</label>
                        <select class="form-control" id="usuario" name="usuario" required>    
                            <option value="" disabled selected>Seleccione un usuario</option>
                            <% if (listaUsuarios != null) { %>
                            <% for (Usuario usuarios : listaUsuarios) {%>
                            <option value="<%= usuarios.getId_usuario()%>">
                            <%= usuarios.getNombre_usuario()%>
                            </option>
                            <% } %>
                            <% } else { %>
                            <option value="" disabled>No hay usuario disponible</option>
                            <% } %>
                        </select>
                </div>                 
        </div>
        
        <button  class="btn btn-primary btn-user btn-block" type = "submit" >
            Crear Odontologo
        </button>
        
       
        <hr>
    
    </form>

    <%@include file="components/bodyInf.jsp" %>


