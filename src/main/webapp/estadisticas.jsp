<%@page import="com.mycompany.odontoweb.Logica.Paciente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    
    <%@include file="components/header.jsp" %>
    <%@include file="components/bodySup.jsp" %>
    
    <%  List<Paciente> listaPacientes = (List) request.getSession().getAttribute("listaPacientes"); %>

    <div class="d-flex justify-content-between">
        <div class="card-body" style="width: 18rem;">
            <div class="table-responsive">
                <table class="table table-bordered"  width="10%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Pacientes activos</th>                                            
                        </tr>
                    </thead>                                 
                    <tbody>                                        
                        <tr>                                            
                            <td>Cantidad de pacientes : <%= listaPacientes.size()%></td>                                                                                   
                        </tr>             
                    </tbody>
                </table>
            </div>
        </div>
        <% int pacientesObraSocial = 0;
            if(listaPacientes != null){
             for(Paciente paciente : listaPacientes){
             if(paciente.getTiene_os()!= null && !paciente.getTiene_os().isEmpty()){
              pacientesObraSocial++;
                    }
                }
            }
        
        %>
        <div class="card-body" style="width: 18rem;">
            <div class="table-responsive">
                <table class="table table-bordered"  width="10%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Pacientes con obra social</th>                                            
                        </tr>
                    </thead>                                 
                    <tbody>                                        
                        <tr>                                            
                            <td>Cantidad de pacientes con obra social : <%= pacientesObraSocial%></td>                                                                                   
                        </tr>             
                    </tbody>
                </table>
            </div>
        </div>
    </div>    
    

    
    <script src="vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/datatables-demo.js"></script>
    
    <%@include file="components/bodyInf.jsp" %>
           
</html>>           
