let borrar = function (id) {
    fetch(`http://localhost:7000/productores/${id}`, {
            method: 'DELETE',
        }
    ).then(res => location.reload());
}