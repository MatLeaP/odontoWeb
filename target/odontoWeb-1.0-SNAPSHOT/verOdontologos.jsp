
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
                    <h1 class="h3 mb-2 text-gray-800">Odontologos</h1>
                    

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Odontologos disponibles</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Dni</th>
                                            <th>Nombre del odontologo</th>
                                            <th>Apellido</th>
                                            <th>Telefono</th>
                                            <th>Direccion</th>
                                            <th>Fecha de nacimiento</th>
                                            <th>Especialidad</th>
                                            <th style="width:210px">Accion</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Dni</th>
                                            <th>Nombre del odontologo</th>
                                            <th>Apellido</th>
                                            <th>Telefono</th>
                                            <th>Direccion</th>
                                            <th>Fecha de nacimiento</th>
                                            <th>Especialidad</th>
                                            <th style="width:210px">Accion</th>
                                        </tr>
                                    </tfoot>
                                    
                                    <%
                                    List <Odontologo> listaOdontologos = (List) request.getSession().getAttribute("listaOdontologos");
                                    %>
                                    <tbody>
                                        <%for(Odontologo odon : listaOdontologos){%>
                                        <tr>                                            
                                            <td><%= odon.getDni()%></td>
                                            <td><%= odon.getNombre()%></td>
                                            <td><%= odon.getApellido()%></td>
                                            <td><%= odon.getTelefono()%></td>
                                            <td><%= odon.getDireccion()%></td>
                                            <td><%= odon.getFecha_nac()%></td>
                                            <td><%= odon.getEspecialidad()%></td>
                                            <td style="display:flex; width:230px;">
                                                <form name="eliminar" action="SvEliminarOdontologos" method="POST">
                                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color:red; margin-rigth:5px;">
                                                        <i class="fas fa-trash-alt"></i>
                                                    </button>
                                                    <input type="hidden" name="id" value="<%= odon.getId() %>">
                                                </form>
                                                <form name="editar" action="SvEditarOdontologo" method="GET">
                                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color:blue; margin-left:5px;">
                                                        <i class="fas fa-edit"></i>
                                                    </button>
                                                    <input type="hidden" name="id" value="<%= odon.getId()%>">
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