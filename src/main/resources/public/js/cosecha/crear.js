$(document).ready(function () {
    $("form").submit(function (event) {
        event.preventDefault();

        var formData = {
            pesoEntrega: $("#pesoEntrega").val(),
            tiempoEntrega: $("#tiempoEntrega").val(),
            pesoRegistro: $("#pesoRegistro").val(),
            tiempoRegistro: $("#tiempoRegistro").val(),
            secadero: $("#secadero").val(),
            empleado: $("#empleado").val()
        };

        var url = $(this).attr("action");

        $.post(url, formData, function () {
        })
            .done(function () {
                alert("Cosecha agregada correctamente.");
                location.href = "/cosechas";
            })
            .fail(function () {
                alert("Ha ocurrido un Error");
                location.reload();
            })
            .always(function () {

            });
    });
});