
<%@page import="com.mycompany.odontoweb.Logica.Secretario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    
    <%@include file="components/header.jsp" %>
    <%@include file="components/bodySup.jsp" %>

    <% Secretario secre = (Secretario) request.getSession().getAttribute("secretario");%>
    <h1>Editar Secretario</h1>
    <form class="user" action="SvEditarSecretario" method="POST">
        <div class="form-group col">
            <div class="col-sm-6 mb-3">
                <input type="text" class="form-control form-control-user" id="dni" name="dni"
                       placeholder="DNI" value="<%= secre.getDni() %>">
            </div>
            <div class="col-sm-6 mb-3">
                <input type="text" class="form-control form-control-user" id="nombre" name="nombre"
                       placeholder="Nombre" value="<%= secre.getNombre() %>">
            </div>
            <div class="col-sm-6 mb-3">
                <input type="text" class="form-control form-control-user" id="apellido" name="apellido"
                       placeholder="Apellido" value="<%= secre.getApellido() %>">
            </div>
            <div class="col-sm-6 mb-3">
                <input type="text" class="form-control form-control-user" id="telefono" name="telefono"
                       placeholder="Telefono" value="<%= secre.getTelefono() %>">
            </div>
            <div class="col-sm-6 mb-3">
                <input type="text" class="form-control form-control-user" id="direccion" name="direccion"
                       placeholder="Direccion" value="<%= secre.getDireccion() %>">
            </div>
            <div class="col-sm-6 mb-3">
                <input type="date" class="form-control form-control-user" id="fechanac" name="fechanac"
                       placeholder="Fecha de nacimiento" value="<%= secre.getFecha_nac() %>" required>
            </div>
            <div class="col-sm-6 mb-3">
                <input type="text" class="form-control form-control-user" id="area" name="area"
                       placeholder="Area" value="<%= secre.getArea() %>" >
            </div>
        </div>
        
        
        
        <button  class="btn btn-primary btn-user btn-block" type = "submit" >
            Guardar modificaciones
        </button>
        <hr>
    
    </form>

    <%@include file="components/bodyInf.jsp" %>