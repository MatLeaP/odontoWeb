<%@page import="com.mycompany.odontoweb.Logica.Turno"%>
<%@page import="com.mycompany.odontoweb.Logica.Paciente"%>
<%@page import="com.mycompany.odontoweb.Logica.Odontologo"%>
<%@page import="com.mycompany.odontoweb.Logica.Usuario"%>
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
                            <h6 class="m-0 font-weight-bold text-primary">Listado de turnos</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Paciente</th>
                                            <th>Odontologo</th>
                                            <th>Hora</th>
                                            <th>Fecha</th>
                                            <th>Afeccion</th>                                            
                                            <th style="width:210px">Accion</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Paciente</th>
                                            <th>Odontologo</th>
                                            <th>Hora</th>
                                            <th>Fecha</th>
                                            <th>Afeccion</th>                                            
                                            <th style="width:210px">Accion</th>
                                        </tr>
                                    </tfoot>
                                    
                                    <%
                                    List <Turno> listaTurnos = (List) request.getSession().getAttribute("listaTurnos");
                                    %>
                                    <tbody>
                                        <%for(Turno turno : listaTurnos){%>
                                        <tr>                                            
                                            <td><%= turno.getPacien().getNombre() %></td>
                                            <td><%= turno.getOdonto().getNombre() %></td>
                                            <td><%= turno.getHora_turno().getHorarioInicio() %></td>
                                            <td><%= turno.getFecha_turno() %></td>
                                            <td><%= turno.getAfeccion() %></td>                                                                                      
                                            <td style="display:flex; width:230px;">
                                                <form name="eliminar" action="SvEliminarTurno" method="POST">
                                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color:red; margin-rigth:5px;">
                                                        <i class="fas fa-trash-alt"></i>
                                                    </button>
                                                    <input type="hidden" name="id" value="<%= turno.getId_turno() %>">
                                                </form>                                               
                                            </td>
                                        </tr>              
                                        <%}%>   
                                    </tbody>
                                </table>
                            </div>
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