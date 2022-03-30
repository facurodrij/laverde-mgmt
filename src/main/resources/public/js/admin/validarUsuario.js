$(document).ready(function () {
    $("form").submit(function (event) {
        event.preventDefault();

        var formData = {
            nombreUsuario: $("#nombreUsuario").val(),
            contrasenia: $("#contrasenia").val()
        };

        var url = $(this).attr("action");

        $.post(url, formData, function () {
        })
            .done(function () {
                location.replace("/admin/cosechas");
            })
            .fail(function () {
                location.reload();
            });
    });
});
