let borrar = function (id) {
    fetch(`http://localhost:7000/secaderos/${id}`, {
        method: 'DELETE',
    }
    ).then(res => location.reload());
}