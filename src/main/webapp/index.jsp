<%-- 
    Document   : index
    Created on : 20-nov-2023, 21:53:42
    Author     : Pato
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Operacion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class='container-fluid'>
            <form action="myServlet"method="POST" >
              
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Ingrese número uno</label>
                    <input type="number" step=".01" name="numero1" class="form-control"  aria-describedby="emailHelp">
                </div>
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Ingrese número dos</label>
                    <input type="number" step=".01" name="numero2" class="form-control"  aria-describedby="emailHelp">
                </div>
               

                <div class="mb-3">
                    <input type="submit" name="operacion" class="btn btn-success" value="Sumar">
                    <input type="submit" name="operacion" class="btn btn-primary" value="Restar">
                    <input type="submit" name="operacion" class="btn btn-warning" value="Multiplicar">
                    <input type="submit" name="operacion" class="btn btn-dark" value="Dividir">
                </div>
                <div class="mb-3">
                    <input type="submit" name="operacion" class="btn btn-primary" value="Reporte">
                </div>
                <div class="mb-3">
                     <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Ingrese el resultado a actualizar</label>
                    <input type="number" step=".01" name="resultadoTodo" class="form-control"  aria-describedby="emailHelp">
                </div>
                    <label for="exampleInputEmail1" class="form-label">Ingrese el id a buscar o a Actualizar</label>
                    <input type="number" step=".01" name="buscarUno" class="form-control"  aria-describedby="emailHelp">
                    <input type="submit" name="operacion" class="btn btn-primary" value="Buscar">
                    <input type="submit" name="operacion" class="btn btn-danger" value="Eliminar">
                    <input type="submit" name="operacion" class="btn btn-success" value="Actualizar">
                    <input type="submit" name="operacion" class="btn btn-warning" value="Actualizar Todo">
                </div>

                <div class="mb-3">
                    <%
                        if (request.getAttribute("cajitarespuesta") != null) {
                            out.println(request.getAttribute("cajitarespuesta"));
                    %>
                    <br>
                    <%
                            out.println(request.getAttribute("cajitaBD"));

                        }
                    %>
                </div>
                <div class="panel-body table-responsive" > 
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>idOperacion</th>
                                <th>Dato 1</th>
                                <th>Dato 2</th>
                                <th>resultado</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                ArrayList<Operacion> listaOperaciones = (ArrayList<Operacion>) request.getAttribute("cajitaReporte");
                                ArrayList<Operacion> mostrarUno = (ArrayList<Operacion>) request.getAttribute("cajitaReporteUno");

                                if (listaOperaciones != null && mostrarUno != null) {
                                    // Combina ambas listas antes del bucle
                                    listaOperaciones.addAll(mostrarUno);

                                    for (Operacion operacion : listaOperaciones) {
                            %>
                            <tr>
                                <td><%= operacion.getIdOperacion()%></td>
                                <td><%= operacion.getDato1()%></td>
                                <td><%= operacion.getDato2()%></td>
                                <td><%= operacion.getResultado()%></td>
                                <td><%= operacion.getOperacion()%></td>
                            </tr>
                            <%   }
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </form>
        </div>
    </body>
</html>