$(document).ready(function () {
    $("form").submit(function (event) {
        event.preventDefault();

        var formData = {
            
        };

        var url = $(this).attr("action");

        $.post(url, formData, function () {
        })
            .done(function () {
                alert("Cosecha actualizada correctamente.");
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