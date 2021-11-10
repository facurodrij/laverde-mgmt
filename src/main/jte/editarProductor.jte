@param edu.unam.jte.paginas.ModeloProductor modelo

@tag.header()

<h2> Hello ${modelo.productor.getNombres()} </h2>

<form action="/productores" method="post">
    <div class="form-group row">
        <label for="cuit" class="col-sm-2 col-form-label"> CUIT del productor </label>
        <div class="col-sm-8">
            <input class="form-control" type="text" placeholder="Ingrese el cuit" name="cuit" value="${modelo.productor.getCuit()}"/>
        </div>
    </div>
    <div class="form-group row">
        <label for="nombre" class="col-sm-2 col-form-label"> Nombre del productor </label>
        <div class="col-sm-8">
            <input class="form-control" type="text" placeholder="Ingrese el nombre" name="nombres" value="${modelo.productor.getNombres()}"/>
        </div>
    </div>
    <div class="form-group row">
        <label for="apellido" class="col-sm-2 col-form-label"> Apellido del productor </label>
        <div class="col-sm-8">
            <input class="form-control" type="text" placeholder="Ingrese el apellido" name="apellidos" value="${modelo.productor.getApellidos()}"/>
        </div>
    </div>
    <button type="button" class="btn btn-primary"> Guardar </button>
    <a href="/" type="button" class="btn btn-secondary"> Volver </a>
</form>

<script src="/js/productores.js"></script>

@tag.footer()