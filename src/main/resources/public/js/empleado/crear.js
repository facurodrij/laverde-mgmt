$(document).ready(function () {
    $("form").submit(function (event) {
        event.preventDefault();

        var formData = {
            legajo: $("#legajo").val(),
            dni: $("#dni").val(),
            cuil: $("#cuil").val(),
            nombres: $("#nombres").val(),
            apellidos: $("#apellidos").val(),
            ingreso: $("#ingreso").val(),
            nacimiento: $("#nacimiento").val(),
        };

        var url = $(this).attr("action");

        $.post(url, formData, function () {
        })
            .done(function () {
                alert("Empleado agregado correctamente.");
                location.href = "/empleados";
            })
            .fail(function () {
                alert("Ha ocurrido un Error");
                location.reload();
            })
            .always(function () {

            });
    });
});