<%@page import="com.mycompany.odontoweb.Logica.Responsable"%>
<%@page import="java.util.List"%>
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
                       placeholder="Fecha de nacimiento" required onchange="validarEdad()">
            </div>

            <!-- Contenedor donde se generará dinámicamente el botón -->
            <div id="contenedorResponsable" class="col-sm-6 mb-3"></div>        
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
            <% List <Responsable> listaResponsables = (List) request.getSession().getAttribute("listaResponsables"); %>
            <div class="col-sm-6 mb-3">
                    <label for="usuario">Seleccione un responsable:</label>
                        <select class="form-control" id="responsable" name="responsable" required>                            
                            <option value="" disabled selected>Seleccione un responsable</option>
                            <% if (listaResponsables != null) { %>
                            <% for (Responsable resp : listaResponsables) {%>
                            <option value="<%= resp.getId() %>">
                            <%= resp.getNombre()%>  <%=resp.getApellido() %>
                            </option>
                            <% } %>
                            <% } else { %>
                            <option value="" disabled>No hay responsables disponible</option>
                            <% } %>
                        </select>
                </div>                 
        </div>
        
        <button  class="btn btn-primary btn-user btn-block" type = "submit" >
            Crear paciente
        </button>
        
       
        <hr>
    
    </form>
    
                        <script>
                        // Función para calcular la edad en base a la fecha de nacimiento
                        function calcularEdad(fechaNacimiento) {
                            const hoy = new Date();
                            const fechaNac = new Date(fechaNacimiento);
                            let edad = hoy.getFullYear() - fechaNac.getFullYear();
                            const mes = hoy.getMonth() - fechaNac.getMonth();
                            if (mes < 0 || (mes === 0 && hoy.getDate() < fechaNac.getDate())) {
                                edad--;
                            }
                            return edad;
                        }

                        // Función para validar la edad y generar el botón si es menor de 18 años
                        function validarEdad() {
                            const fechaNacInput = document.getElementById('fechanac').value;
                            const edad = calcularEdad(fechaNacInput);
                            const contenedor = document.getElementById('contenedorResponsable');

                            // Limpia el contenido del contenedor
                            contenedor.innerHTML = '';

                            if (edad < 18) {
                                // Crea un botón dinámico para registrar un responsable
                                const boton = document.createElement('button');
                                boton.type = 'button';
                                boton.className = 'btn btn-secondary btn-user btn-block';
                                boton.textContent = 'Crear Responsable';
                                boton.onclick = function () {
                                    window.location.href = 'altaResponsable.jsp'; // Cambiar por la URL de creación de responsable
                                };
                                contenedor.appendChild(boton);
                            }
                        }
                        </script>

                        
                        
                        
    <%@include file="components/bodyInf.jsp" %>


