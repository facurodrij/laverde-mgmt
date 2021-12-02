let borrar = function (id) {
    fetch(`http://localhost:7000/cosechas/${id}`, {
        method: 'DELETE',
    }
    ).then(res => location.reload());
}