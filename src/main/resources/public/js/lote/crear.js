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

        $.post(url, formData, function () {
        })
            .done(function () {
                $("#punto1X").val("");
                $("#punto1Y").val("");
                $("#punto2X").val("");
                $("#punto2Y").val("");
                $("#productor").val("");
            })
            .always(function () {
                location.reload();
            });
    });
});
