let cerrarSesion = function () {
    fetch(`http://localhost:7000/`, {
        method: 'POST',
    }
    ).then(res => location.reload());
}
