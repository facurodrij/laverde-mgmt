$(document).ready(function () {
    $("form").submit(function (event) {
        event.preventDefault();

        var formData = {
            cuit: $("#cuit").val(),
            razonSocial: $("#razonSocial").val(),
        };

        console.log(formData.empleado);

        var url = $(this).attr("action");

        $.post(url, formData, function () {
        })
            .done(function () {
                $("#cuit").val(""),
                $("#razonSocial").val("");
            })
            .always(function () {
                location.reload();
            });
    });
});