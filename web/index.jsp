<%-- 
    Document   : index
    Created on : 22/09/2020, 11:17:31 AM
    Author     : angel
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo CRUD JPA Mysql</title>
        <link href="resource/Css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-md-3">
                <div class="card mt-3 ml-3">
                    <div class="card-header text-center">
                        <label class="">CAMPOS PARA EL REGISTRO DEL USUARIO</label>
                    </div>
                    <div class="card-body">
                        <label for="codigoId">*Ingrese el id del usuario:</label>
                        <input type="number" id="codigoId" class="form-control" placeholder="Ingrese el codigo del usuario">
                        <br>
                        <label for="nombre">*Ingrese el nombre del usuario:</label>
                        <input type="text" id="nombre" class="form-control" placeholder="Ingrese el nombre del usuario">
                        <br>
                        <label for="apellido">*Ingrese el apellido del usuario:</label>
                        <input type="text" id="apellido" class="form-control" placeholder="Ingrese el apellido del usuario">  
                        <br>
                        <label for="sueldo">*Ingrese el sueldo del usuario:</label>
                        <input type="number" id="sueldo" class="form-control" placeholder="Ingrese el sueldo del usuario">  
                        <br>
                        <button class="btn btn-outline-info w-100" id="btnRegistrar">Registrar</button>
                        <button class="btn btn-outline-success w-100 mt-3" id="btnActualizar">Actualizar</button>
                        <a href="Controlador?accion=Listar" class="btn btn-outline-primary w-100 mt-3" id="btnListar">Listar Informacion</a>
                    </div>
                </div>
            </div>
            <div class="col-md-9">
                <table class="table table-hover mt-3 ml-3" id="tabla">
                    <thead class="bg-light">
                        <tr>
                            <th>CODIGO</th>
                            <th>NOMBRE</th>
                            <th>APELLIDO</th>
                            <th>SUELDO</th>
                            <th>FECHA CONT.</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <c:forEach items="${persona}" var="p">
                        <tr onclick="enviarRegistroInputsEditar(this)" style="cursor: pointer">
                            <td>${p.getCodigoId()}</td>
                            <td>${p.getNombre()}</td>
                            <td>${p.getApellido()}</td>
                            <td>${p.getSueldo()}</td>
                            <td>${p.getFechaIngreso()}</td>
                            <td>
                                <input type="hidden" id="codigoEliminar" value="${p.getCodigoId()}">
                                <button class="btn btn-danger" id="btnEliminar">Eliminar</button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
    <script src="resource/Js/jquery-3.5.1.js" type="text/javascript"></script>
    <script src="resource/Js/sweetalert2@10.js" type="text/javascript"></script>
    <script src="resource/Js/app.js" type="text/javascript"></script>
</html>
