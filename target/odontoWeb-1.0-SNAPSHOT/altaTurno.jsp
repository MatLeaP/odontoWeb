<%@page import="com.mycompany.odontoweb.Logica.Paciente"%>
<%@page import="com.mycompany.odontoweb.Logica.Odontologo"%>
<%@page import="java.util.List"%>
<html>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@include file="components/header.jsp" %>
    <%@include file="components/bodySup.jsp" %>

    <h1>Alta turnos</h1>
    <form class="user" action="SvTurnos" method="POST">
        <div class="form-group col">
            <% List<Paciente> listaPacientes = (List<Paciente>) request.getSession().getAttribute("listaPacientes"); %>
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

            <% List<Odontologo> listaOdontologos = (List<Odontologo>) request.getSession().getAttribute("listaOdontologos"); %>
            <div class="col-sm-6 mb-3">
                <label for="odontologo">Seleccione un Odontólogo:</label>
                <select class="form-control" id="odontologo" name="odontologoId" required>
                    <option value="" disabled selected>Seleccione un odontólogo</option>
                    <%
                        if (listaOdontologos != null) {
                            for (Odontologo odonto : listaOdontologos) {
                    %>
                        <option value="<%= odonto.getId()%>">
                            <%= odonto.getNombre()%> <%= odonto.getApellido()%>
                        </option>
                    <%
                            }
                        } else {
                    %>
                        <option value="" disabled>No hay odontólogos disponibles</option>
                    <%
                        }
                    %>
                </select>
            </div>

            <div class="col-sm-6 mb-3">
                <label for="horario_turno">Seleccione un Horario:</label>
                <select class="form-control" id="horario_turno" name="horario_turno" required>
                    <option value="" disabled selected>Seleccione un horario</option>
                </select>
            </div>
            <div class="col-sm-6 mb-3">
                <input type="date" class="form-control form-control-user" id="fecha_turno" name="fecha_turno" placeholder="Fecha">
            </div>
            <div class="col-sm-6 mb-3">
                <input type="text" class="form-control form-control-user" id="afeccion" name="afeccion" placeholder="Afección">
            </div>
        </div>

        <button class="btn btn-primary btn-user btn-block" type="submit">Generar turno</button>

        <hr>
    </form>

        <script>
                document.getElementById('odontologo').addEventListener('change', function() {
                    const odontologoId = this.value;
                    // Inyectas el contextPath del lado servidor:
                    const contextPath = "<%= request.getContextPath()%>";
                    const horarioSelect = document.getElementById('horario_turno');
                    
                    horarioSelect.innerHTML = '<option value="" disabled selected>Seleccione un horario</option>';
      
      
      
                    const xhr = new XMLHttpRequest();
                    // Concatenas la variable de JS:
                    xhr.open("GET", contextPath + "/SvObtenerHorarios?odontologoId=" + odontologoId);
      
                    xhr.onload = function () {
                    if (xhr.status === 200) {
                        const horarios = JSON.parse(xhr.responseText);

                // Iterar sobre los horarios recibidos y agregarlos al select
                    horarios.forEach(horario => {
                        console.log(horario.horarioInicio);
                    const option = document.createElement('option');
                    option.value = horario.id; // Asignar el id del horario como valor
                    option.textContent = "Inicio: "  + horario.horarioInicio  + " Fin: " + horario.horarioFin; // Mostrar el rango de horario
                    horarioSelect.appendChild(option);;
                });
            } else {
                console.error('Error al obtener los horarios:', xhr.statusText);
                alert('No se pudieron cargar los horarios. Intente nuevamente.');
            }
        };

                xhr.onerror = function () {
                    console.error('Error en la solicitud AJAX.');
                    alert('Error al comunicarse con el servidor.');
                };

                xhr.send();
    });
        </script>


    <%@include file="components/bodyInf.jsp" %>