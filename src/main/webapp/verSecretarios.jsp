
<%@page import="com.mycompany.odontoweb.Logica.Secretario"%>
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
                    <h1 class="h3 mb-2 text-gray-800">Secretarios</h1>
                    

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Listado de secretarios</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Dni</th>
                                            <th>Nombre</th>
                                            <th>Apellido</th>
                                            <th>Telefono</th>
                                            <th>Direccion</th>
                                            <th>Fecha de nacimiento</th>
                                            <th>Area</th>
                                            <th style="width:210px">Accion</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Dni</th>
                                            <th>Nombre</th>
                                            <th>Apellido</th>
                                            <th>Telefono</th>
                                            <th>Direccion</th>
                                            <th>Fecha de nacimiento</th>
                                            <th>Area</th>
                                            <th style="width:210px">Accion</th>
                                        </tr>
                                    </tfoot>
                                    
                                    <%
                                    List <Secretario> listaSecretarios = (List) request.getSession().getAttribute("listaSecretarios");
                                    %>
                                    <tbody>
                                        <%for(Secretario secre : listaSecretarios){%>
                                        <tr>                                            
                                            <td><%= secre.getDni()%></td>
                                            <td><%= secre.getNombre()%></td>
                                            <td><%= secre.getApellido()%></td>
                                            <td><%= secre.getTelefono()%></td>
                                            <td><%= secre.getDireccion()%></td>
                                            <td><%= secre.getFecha_nac()%></td>
                                            <td><%= secre.getArea()%></td>                                            
                                            <td style="display:flex; width:230px;">
                                                <form name="eliminar" action="SvEliminarSecretario" method="POST">
                                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color:red; margin-rigth:5px;">
                                                        <i class="fas fa-trash-alt"></i>
                                                    </button>
                                                    <input type="hidden" name="id" value="<%= secre.getId() %>">
                                                </form>
                                                <form name="editar" action="SvEditarSecretario" method="GET">
                                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color:blue; margin-left:5px;">
                                                        <i class="fas fa-edit"></i>
                                                    </button>
                                                    <input type="hidden" name="id" value="<%= secre.getId()%>">
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