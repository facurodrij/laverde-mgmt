$(document).ready(function () {
    $("form").submit(function (event) {
        event.preventDefault();

        var formData = {
        cuit: $("#cuit").val(),
        nombres: $("#nombres").val(),
        apellidos: $("#apellidos").val(),
        };
        console.log(formData);

        var url = "/productores/".concat($("#idProductor").val())

        $.post(url,formData,function(){
        })
        .done(function() {
            alert("Productor actualizado correctamente.");
            location.href="/productores";
        })
        .fail(function() {
            alert("Ha ocurrido un Error, Verifique el campo CUIT.");
        })
        .always(function() {
            
        });
    });
});