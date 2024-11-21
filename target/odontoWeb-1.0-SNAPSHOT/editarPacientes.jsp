
<%@page import="com.mycompany.odontoweb.Logica.Paciente"%>
<%@page import="com.mycompany.odontoweb.Logica.Odontologo"%>
<%@page import="com.mycompany.odontoweb.Logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    
    <%@include file="components/header.jsp" %>
    <%@include file="components/bodySup.jsp" %>

    <% Paciente pacien = (Paciente) request.getSession().getAttribute("pacienEditar");%>
    <h1>Editar Usuarios</h1>
    <form class="user" action="SvEditarPaciente" method="POST">
        <div class="form-group col">
            <div class="col-sm-6 mb-3">
                <input type="text" class="form-control form-control-user" id="dni" name="dni"
                       placeholder="DNI" value="<%= pacien.getDni() %>">
            </div>
            <div class="col-sm-6 mb-3">
                <input type="text" class="form-control form-control-user" id="nombre" name="nombre"
                       placeholder="Nombre" value="<%= pacien.getNombre() %>">
            </div>
            <div class="col-sm-6 mb-3">
                <input type="text" class="form-control form-control-user" id="apellido" name="apellido"
                       placeholder="Apellido" value="<%= pacien.getApellido() %>">
            </div>
            <div class="col-sm-6 mb-3">
                <input type="text" class="form-control form-control-user" id="telefono" name="telefono"
                       placeholder="Telefono" value="<%= pacien.getTelefono() %>">
            </div>
            <div class="col-sm-6 mb-3">
                <input type="text" class="form-control form-control-user" id="direccion" name="direccion"
                       placeholder="Direccion" value="<%= pacien.getDireccion() %>">
            </div>
            <div class="col-sm-6 mb-3">
                <input type="date" class="form-control form-control-user" id="fechanac" name="fechanac"
                       placeholder="Fecha de nacimiento" value="<%= pacien.getFecha_nac() %>" required>
            </div>
             <div>
                <label for="os">¿Tiene obra social?</label>
                <select id="os" name="os">
                    <option value="" disabled selected>Seleccione...</option>
                    <option value="si">Sí</option>
                    <option value="no">No</option>
                </select>
            </div>       
            <div class="col-sm-6 mb-3">
                <input type="text" class="form-control form-control-user" id="tipo_sangre" name="tipo_sangre"
                       placeholder="Tipo de sangre" value="<%= pacien.getTipo_sangre() %>">
            </div>
        </div>
        
        
        
        <button  class="btn btn-primary btn-user btn-block" type = "submit" >
            Guardar modificaciones
        </button>
        <hr>
    
    </form>

    <%@include file="components/bodyInf.jsp" %>

