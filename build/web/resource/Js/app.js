/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {
    /* Evento para realizar un registro en la base de datos */
    $('#btnRegistrar').on('click', function (e) {
        let json = {
            "codigo": $('#codigoId').val(),
            "nombre": $('#nombre').val(),
            "apellido": $('#apellido').val(),
            "sueldo": $('#sueldo').val(),
            "accion": "POST"
        };
        let camposVacios = getCamposVacios(json);
        if (camposVacios) {
            getMensajeAviso("INGRESE TODOS LOS CAMPOS", "No deje campos sin llenar");
        } else {
            let url = "Controlador";
            let ajax = getEnviarAjax(url, json);
            ajax.done(function (response) {
                switch (response) {
                    case 0:
                        getMensajeAviso("Ocurrio un error al conectarse con la base de datos", "No hay conexion");
                        break;
                    case 1:
                        window.location.href = "Controlador?accion=Listar";
                        break;
                    case 2:
                        getMensajeAviso("Ocurrio un error al momento realizar el registro", "Verifique bien sus datos");
                        break;
                }
                console.log(response);
            });
            ajax.fail(function (response) {
                console.log("Error");
                console.log(response);
            });
            return false;
        }
    });

    /* Evento para eliminar un registro de la tabla */
    $('tr #btnEliminar').click(function (e) {
        let codigoId = $(this).parent().find('#codigoEliminar').val();
        let ajax = $.ajax({
            method: "POST",
            url: "Controlador",
            data: {
                "codigoId": codigoId,
                "accion": "DELETE"
            }
        });
        ajax.done(function (response) {
            response = parseInt(response);
            switch (response) {
                case 0:
                    getMensajeAviso("Ocurrio un error al conectarse con la base de datos", "No hay conexion");
                    break;
                case 1:
                    console.log(response);
                    window.location.href = "Controlador?accion=Listar";
                    break;
                case 2:
                    getMensajeAviso("Ocurrio un error al momento realizar el registro", "Verifique bien sus datos");
                    break;
                default:
                    console.log("Respuesta Default: " + response)
                    break;
            }
        });
        ajax.fail(function (response) {
            getMensajeAviso("No se pudo eliminar el registro", "Ocurrio un problema");
            console.log("Error");
            console.log(response);
        });
    });

    /* Evento para realizar actualizcion de un registro */
    $('#btnActualizar').on('click', function (e) {
        let json = {
            "codigo": $('#codigoId').val(),
            "nombre": $('#nombre').val(),
            "apellido": $('#apellido').val(),
            "sueldo": $('#sueldo').val(),
            "accion": "PUT"
        };
        let camposVacios = getCamposVacios(json);
        if (camposVacios) {
            getMensajeAviso("INGRESE TODOS LOS CAMPOS", "No deje campos sin llenar");
        } else {
            let url = "Controlador";
            let ajax = getEnviarAjax(url, json);
            ajax.done(function (response) {
                response = parseInt(response);
                switch (response) {
                    case 0:
                        getMensajeAviso("Ocurrio un error al conectarse con la base de datos", "No hay conexion");
                        break;
                    case 1:
                        console.log(response);
                        window.location.href = "Controlador?accion=Listar";
                        break;
                    case 2:
                        getMensajeAviso("Ocurrio un error al momento realizar el registro", "Verifique bien sus datos");
                        break;
                }
                console.log(response);
            });
            ajax.fail(function (response) {
                console.log("Error");
                console.log(response);
            });
            return false;
        }
    });


    function getEnviarAjax(url, json) {
        let ajax = $.ajax({
            method: "POST",
            url: url,
            data: json
        });
        return ajax;
    }

    function getCamposVacios(json) {
        if (json.codigoId == "") {
            return true;
        }
        if (json.nombre == "") {
            return true;
        }
        if (json.apellido == "") {
            return true;
        }
        if (json.sueldo == "") {
            return true;
        }
        return false;
    }

    function getMensajeAviso(texto, footer) {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: texto,
            footer: footer
        })
    }
});

function enviarRegistroInputsEditar(x) {
    let fila = x.rowIndex;
    let tabla = document.getElementById('tabla');
    $('#codigoId').val(tabla.rows[fila].cells[0].innerHTML);
    $('#nombre').val(tabla.rows[fila].cells[1].innerHTML);
    $('#apellido').val(tabla.rows[fila].cells[2].innerHTML);
    $('#sueldo').val(tabla.rows[fila].cells[3].innerHTML);
}
