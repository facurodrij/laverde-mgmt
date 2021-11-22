$(document).ready(function () {
    $("form").submit(function (event) {
        event.preventDefault();

        var formData = {
        cuit: $("#cuit").val(),
        nombres: $("#nombres").val(),
        apellidos: $("#apellidos").val(),
        };
        console.log(formData);

        $.post("/productores",formData,function(){
        })
        .done(function() {
            alert("Productor agregado correctamente.");
            location.href="/productores";
        })
        .fail(function() {
            alert("Ha ocurrido un Error, Verifique el campo CUIT.");
        })
        .always(function() {
            
        });
    });
});