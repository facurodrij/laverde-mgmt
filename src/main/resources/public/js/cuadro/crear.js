$(document).ready(function () {
    $("form").submit(function (event) {
        event.preventDefault();

        var formData = {
            descripcion: $("#descripcion").val(),
            lote: $("#lote").val()
        };

        var url = $(this).attr("action");

        $.post(url, formData, function () {
        })
            .done(function () {
                alert("Cuadro agregado correctamente.");
                location.href = "/cuadros";
            })
            .fail(function () {
                alert("Ha ocurrido un Error");
                location.reload();
            })
            .always(function () {

            });
    });
});