$(document).ready(function () {
    $("form").on("submit", function(event) {
        event.preventDefault();

        var formData = {id: $("#id").val()};

        var url = location.href;

        $.post(url, formData, function () {
        })
            .always(function () {
                location.reload();
            });
    });
});