let borrar = function (tabla, id) {
    fetch(`http://localhost:7000/admin/${tabla}/${id}`, {
        method: 'DELETE',
    }
    ).then(res => location.reload());
}