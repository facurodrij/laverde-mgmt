let borrar = function (id) {
    fetch(`http://localhost:7000/lotes/${id}`, {
            method: 'DELETE',
        }
    ).then(res => location.reload());
}