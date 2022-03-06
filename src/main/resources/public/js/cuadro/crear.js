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
                $("#descripcion").val("");
                $("#lote").val("");
                $('input[id=puntoX]').map(function() {this.value = "";});
                $('input[id=puntoY]').map(function() {this.value = "";});
            })
            .always(function () {
                location.reload();
            });
    });
});