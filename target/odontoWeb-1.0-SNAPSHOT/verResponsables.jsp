<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="com.mycompany.odontoweb.Logica.Responsable"%>
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
                    <h1 class="h3 mb-2 text-gray-800">Responsables</h1>
                    

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Listado de responsables</h6>
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
                                            <th>Tipo de responsable</th>
                                            
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
                                            <th>Tipo de responsable</th>
                                            <th style="width:210px">Accion</th>
                                        </tr>
                                    </tfoot>
                                    
                                    <%
                                    List <Responsable> listaResponsables = (List) request.getSession().getAttribute("listaResponsables");
                                    %>
                                    <tbody>
                                        <%for(Responsable resp : listaResponsables){%>
                                        <tr>                                            
                                            <td><%= resp.getDni()%></td>
                                            <td><%= resp.getNombre()%></td>
                                            <td><%= resp.getApellido()%></td>
                                            <td><%= resp.getTelefono()%></td>
                                            <td><%= resp.getDireccion()%></td>
                                            <td><%= resp.getFecha_nac()%></td>
                                            <td><%= resp.getTipo_responsable()%></td>                                            
                                            <td style="display:flex; width:230px;">
                                                <form name="eliminar" action="SvEliminarResponsables" method="POST">
                                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color:red; margin-rigth:5px;">
                                                        <i class="fas fa-trash-alt"></i>
                                                    </button>
                                                    <input type="hidden" name="id" value="<%= resp.getId() %>">
                                                </form>
                                                <form name="editar" action="SvEditarResponsable" method="GET">
                                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color:blue; margin-left:5px;">
                                                        <i class="fas fa-edit"></i>
                                                    </button>
                                                    <input type="hidden" name="id" value="<%= resp.getId()%>">
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