<html >
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@include file="components/header.jsp" %>
    <%@include file="components/bodySup.jsp" %>

    <h1>Alta pacientes</h1>
    <form class="user" action="SvPacientes" method="POST">
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
                       placeholder="Tipo de sangre">
            </div>
        </div>
        
        <button  class="btn btn-primary btn-user btn-block" type = "submit" >
            Crear paciente
        </button>
        
       
        <hr>
    
    </form>

    <%@include file="components/bodyInf.jsp" %>


