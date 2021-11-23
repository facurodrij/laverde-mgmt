let borrar = function (id) {
    fetch(`http://localhost:7000/cuadros/${id}`, {
        method: 'DELETE',
    }
    ).then(res => location.reload());
}