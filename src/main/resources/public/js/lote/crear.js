$(document).ready(function () {
    $("form").submit(function (event) {
        event.preventDefault();

        var formData = {
            punto1X: $("#punto1X").val(),
            punto1Y: $("#punto1Y").val(),
            punto2X: $("#punto2X").val(),
            punto2Y: $("#punto2Y").val(),
            productor: $("#productor").val(),
        };

        var url = $(this).attr("action");

        $.post(url,formData,function(){
        })
        .done(function() {
            alert("Lote agregado correctamente.");
            location.href="/lotes";
        })
        .fail(function() {
            alert("Ha ocurrido un Error");
        })
        .always(function() {
            
        });
    });
});