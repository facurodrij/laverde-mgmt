$(document).ready(function () {
    $("form").submit(function (event) {
        event.preventDefault();

        var formData = {
            cuit: $("#cuit").val(),
            nombres: $("#nombres").val(),
            apellidos: $("#apellidos").val(),
        };

        var url = $(this).attr("action");

        $.post(url, formData, function () {
        })
            .done(function () {
                alert("Productor actualizado correctamente.");
                location.href = "/productores";
            })
            .fail(function () {
                alert("Ha ocurrido un Error");
                location.reload();
            })
            .always(function () {

            });
    });
});