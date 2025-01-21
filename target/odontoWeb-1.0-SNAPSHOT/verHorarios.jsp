
<%@page import="com.mycompany.odontoweb.Logica.Horario"%>
<%@page import="com.mycompany.odontoweb.Logica.DiaSemana"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%@include file="components/header.jsp" %>
<%@include file="components/bodySup.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Turnos</h1>


    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Listado de turnos.</h6>
        </div>
        <%  List<DiaSemana> listaDias = (List<DiaSemana>) session.getAttribute("listaDias");
            List<Horario> listaHorarios = (List<Horario>) session.getAttribute("listaHorarios");
        %>

        <div class="container mt-5">
            <h2 class="text-center mb-4">Horarios Semanales</h2>
            <table class="table table-bordered text-center">
                <thead>
                    <tr>
                        <% for (DiaSemana dia : (List<DiaSemana>) session.getAttribute("listaDias")) {%>
                        <th><%= dia.name()%></th>
                            <% } %>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (int i = 0; i < listaHorarios.size(); i++) {
                    %>
                    <tr>
                        <% for (DiaSemana dia : listaDias) { %>
                        <td>
                            <!-- Contenedor flexible -->
                            <div style="display: flex; align-items: center; justify-content: space-between;">
                                <!-- Mostrar horario -->
                                <span><%= listaHorarios.get(i).getHorarioInicio() %> - <%= listaHorarios.get(i).getHorarioFin() %></span>
                                <!-- Botones de acción -->
                                <div style="display: flex; gap: 5px; margin-left: 10px;">
                                    <form name="eliminar" action="SvEliminarHorario" method="POST" style="margin: 0;">
                                        <button type="submit" class="btn btn-danger btn-sm">
                                            <i class="fas fa-trash-alt"></i>
                                        </button>
                                        <input type="hidden" name="id" value="<%= listaHorarios.get(i).getId() %>">
                                    </form>
                                    <form name="editar" action="SvEditarHorario" method="GET" style="margin: 0;">
                                        <button type="submit" class="btn btn-primary btn-sm">
                                            <i class="fas fa-edit"></i>
                                        </button>
                                        <input type="hidden" name="id" value="<%= listaHorarios.get(i).getId() %>">
                                    </form>
                                </div>
                            </div>
                        </td>
                        <% } %>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>

</div>
<!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

              <!-- Page level plugins -->
    <script src="vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/datatables-demo.js"></script>
    
    <%@include file="components/bodyInf.jsp" %>