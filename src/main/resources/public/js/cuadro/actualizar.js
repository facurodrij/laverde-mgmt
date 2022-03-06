$(document).ready(function () {
    $("form").submit(function (event) {
        event.preventDefault();

        var formData = {
            descripcion: $("#descripcion").val(),
            lote: $("#lote").val(),
            puntosX: $('input[id=puntoX]').map(function() {return this.value;}).get().toString(),
            puntosY: $('input[id=puntoY]').map(function() {return this.value;}).get().toString()
        };

        var url = $(this).attr("action");

        $.post(url, formData, function () {
        })
            .done(function () {
                location.replace("/cuadros");
            })
            .fail(function () {
                location.reload();
            });
    });
});