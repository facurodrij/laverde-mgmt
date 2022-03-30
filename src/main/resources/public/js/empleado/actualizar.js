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
                location.replace("/admin/empleados");
            })
            .fail(function () {
                location.reload();
            });
    });
});