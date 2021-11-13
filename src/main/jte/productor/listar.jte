@import edu.unam.jte.paginas.ModeloProductores
@param ModeloProductores modelo

@tag.head()

    <h2> Productores </h2>
    <a href="/" type="button" class="btn btn-secondary"> Volver </a>
    <div class="table-responsive">
        <table class="table table-hover table-striped">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">CUIT</th>
                    <th scope="col">Apellidos</th>
                    <th scope="col">Nombres</th>
                    <th class="col-1" scope="col"> </th>
                    <th class="col-1" scope="col"> </th>
                </tr>
            </thead>

            <tbody>
                @for (var productor : modelo.productores)
                    <tr>
                        <td scope="row">${productor.getIdProductor()}</td>
                        <td>${productor.getCuit()}</td>
                        <td>${productor.getApellidos()}</td>
                        <td>${productor.getNombres()}</td>
                        <td class="col-1"> <a type="button" class="btn btn-info no-gutters" href="productores/${productor.getIdProductor()}"> Editar </a></td>                            
                        <td class="col-1"> <button type="button" class="btn btn-danger no-gutters" onClick="borrar(${productor.getIdProductor()})"> Eliminar </button></td>
                    </tr>
                @endfor
            </tbody>
        </table>
    </div>
<script src="/js/productores.js"></script>

@tag.footer()