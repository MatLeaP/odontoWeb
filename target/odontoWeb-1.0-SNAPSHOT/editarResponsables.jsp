
<%@page import="com.mycompany.odontoweb.Logica.Responsable"%>
<%@page import="com.mycompany.odontoweb.Logica.Paciente"%>
<%@page import="com.mycompany.odontoweb.Logica.Odontologo"%>
<%@page import="com.mycompany.odontoweb.Logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    
    <%@include file="components/header.jsp" %>
    <%@include file="components/bodySup.jsp" %>

    <% Responsable resp = (Responsable) request.getSession().getAttribute("resp");%>
    <h1>Editar Usuarios</h1>
    <form class="user" action="SvEditarResponsable" method="POST">
        <div class="form-group col">
            <div class="col-sm-6 mb-3">
                <input type="text" class="form-control form-control-user" id="dni" name="dni"
                       placeholder="DNI" value="<%= resp.getDni() %>">
            </div>
            <div class="col-sm-6 mb-3">
                <input type="text" class="form-control form-control-user" id="nombre" name="nombre"
                       placeholder="Nombre" value="<%= resp.getNombre() %>">
            </div>
            <div class="col-sm-6 mb-3">
                <input type="text" class="form-control form-control-user" id="apellido" name="apellido"
                       placeholder="Apellido" value="<%= resp.getApellido() %>">
            </div>
            <div class="col-sm-6 mb-3">
                <input type="text" class="form-control form-control-user" id="telefono" name="telefono"
                       placeholder="Telefono" value="<%= resp.getTelefono() %>">
            </div>
            <div class="col-sm-6 mb-3">
                <input type="text" class="form-control form-control-user" id="direccion" name="direccion"
                       placeholder="Direccion" value="<%= resp.getDireccion() %>">
            </div>
            <div class="col-sm-6 mb-3">
                <input type="date" class="form-control form-control-user" id="fechanac" name="fechanac"
                       placeholder="Fecha de nacimiento" value="<%= resp.getFecha_nac() %>" required>
            </div>
            <div class="col-sm-6 mb-3">
                <input type="text" class="form-control form-control-user" id="tipo_responsable" name="tipo_responsable"
                       placeholder="Tipo de responsable" value="<%= resp.getTipo_responsable() %>">
            </div> 
        </div>
        
        
        
        <button  class="btn btn-primary btn-user btn-block" type = "submit" >
            Guardar modificaciones
        </button>
        <hr>
    
    </form>

    <%@include file="components/bodyInf.jsp" %>

