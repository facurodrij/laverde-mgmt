$(document).ready(function () {
    $("form").on("submit", function(event) {
        event.preventDefault();

        var formData = {
            usuario: $("#usuario").val(),
            nombreUsuario: $("#nombreUsuario").val(),
            contrasenia: $("#contrasenia").val()
        };

        var url = location.href;

        $.post(url, formData, function () {
        })
            .done(function () {
                location.replace(`/${usuario}/cosechas`);
            })
            .fail(function () {
                location.reload();
            });
    });
});