
<%@page import="com.mycompany.odontoweb.Logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    
    <%@include file="components/header.jsp" %>
    <%@include file="components/bodySup.jsp" %>

    <% Usuario usu = (Usuario) request.getSession().getAttribute("usuEditar");%>
    <h1>Editar Usuarios</h1>
    <form class="user" action="SvEditarUsuario" method="POST">
        <div class="form-group col">
            <div class="col-sm-6 mb-3">
                <input type="text" class="form-control form-control-user" id="nombreUsu" name="nombreUsu"
                       placeholder="Nombre usuario" value="<%=usu.getNombre_usuario() %>">
            </div>
            <div class="col-sm-6 mb-3">
                <input type="password" class="form-control form-control-user" id="contrasenia" name="contrasenia"
                       placeholder="Contraseña" value="<%=usu.getContraseña() %>" >
            </div>
            <div class="col-sm-6 mb-3">
                <input type="text" class="form-control form-control-user" id="rol" name="rol"
                       placeholder="Rol" value="<%=usu.getRol() %>">
            </div>            
        </div>
        
        
        
        <button  class="btn btn-primary btn-user btn-block" type = "submit" >
            Guardar modificaciones
        </button>
        <hr>
    
    </form>

    <%@include file="components/bodyInf.jsp" %>

