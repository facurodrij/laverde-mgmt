let borrar = function (id) {
    fetch(`http://localhost:7000/cursos/${id}`, {
            method: 'DELETE',
        }
    ).then(res => location.reload());
}