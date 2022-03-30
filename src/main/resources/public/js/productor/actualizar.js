$(document).ready(function () {
    $("form").submit(function (event) {
        event.preventDefault();

        var formData = {
            cuit: $("#cuit").val(),
            nombres: $("#nombres").val(),
            apellidos: $("#apellidos").val(),
        };

        var url = $(this).attr("action");

        $.post(url, formData, function () {
        })
            .done(function () {
                location.replace("/admin/productores");
            })
            .fail(function () {
                location.reload();
            });
    });
});