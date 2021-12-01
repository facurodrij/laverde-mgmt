let borrar = function (id) {
    fetch(`http://localhost:7000/empleados/${id}`, {
        method: 'DELETE',
    }
    ).then(res => location.reload());
}