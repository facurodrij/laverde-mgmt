$(document).ready(function () {
    $("form").submit(function (event) {
        event.preventDefault();

        var formData = {
            pesoEntrega: $("#pesoEntrega").val(),
            tiempoEntrega: $("#tiempoEntrega").val(),
            pesoRegistro: $("#pesoRegistro").val(),
            tiempoRegistro: $("#tiempoRegistro").val(),
            secadero: $("#secadero").val(),
            empleado: $("#empleado").val().toString(),
            cuadro: $("#cuadro").val().toString()
        };

        var url = $(this).attr("action");

        $.post(url, formData, function () {
        })
            .done(function () {
                $("#pesoEntrega").val("");
                $("#tiempoEntrega").val("");
                $("#pesoRegistro").val("");
                $("#tiempoRegistro").val("");
                $("#secadero").val("");
                $("#empleado").val("");
                $("#cuadro").val("");
            })
            .always(function () {
                location.reload();
            });
    });
});