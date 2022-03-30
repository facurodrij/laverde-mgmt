$(document).ready(function () {
    $("form").submit(function (event) {
        event.preventDefault();

        var formData = {
            cuit: $("#cuit").val(),
            razonSocial: $("#razonSocial").val(),
        };

        var url = $(this).attr("action");

        $.post(url, formData, function () {
        })
            .done(function () {
                location.replace("/admin/secaderos");
            })
            .fail(function () {
                location.reload();
            });
    });
});