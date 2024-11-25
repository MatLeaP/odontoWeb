
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    
    <%@include file="components/header.jsp" %>
    <%@include file="components/bodySup.jsp" %>

    <h1>Alta Usuarios</h1>
    <form class="user" action="SvHorario" method="POST">
        <div class="form-group col">
            <div class="col-sm-6 mb-3">
                <input type="text" class="form-control form-control-user" id="horario_inicio" name="horario_inicio"
                       placeholder="Horario de inicio">
            </div>
            <div class="col-sm-6 mb-3">
                <input type="text" class="form-control form-control-user" id="horario_fin" name="horario_fin"
                       placeholder="Horario de fin">
            </div>            
        </div>
        
        
        
        <button  class="btn btn-primary btn-user btn-block" type = "submit" >
            Crear usuario
        </button>
        <hr>
    
    </form>

    <%@include file="components/bodyInf.jsp" %>

