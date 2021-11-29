@param edu.unam.jte.paginas.ModeloLote modelo

@tag.head()

@tag.sidebar()

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
  <!-- Content Header (Page header) -->
  <section class="content-header">
    <div class="container-fluid">
      <div class="row mb-2">
        <div class="col-sm-6">
          <h1>Lotes</h1>
        </div>
        <div class="col-sm-6">
          <ol class="breadcrumb float-sm-right">
            <li class="breadcrumb-item"><a href="/">Inicio</a></li>
            <li class="breadcrumb-item"><a href="/lotes">Lotes</a></li>
            <li class="breadcrumb-item active">${modelo.lote.getIdLote()}</li>
          </ol>
        </div>
      </div>
      @if (modelo.exception != null)
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
          ${modelo.exception.getCause().getCause().getMessage()}	
          <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
      @endif
    </div><!-- /.container-fluid -->
  </section>

  <!-- Main content -->
  <section class="content">
    <div class="container-fluid">
      <div class="row">
        <div class="col-12">
          <!-- Default box -->
          <div class="card">
            <div class="card-header">
              <h3 class="card-title">Editar Lote</h3>
            </div>
            <form action="/lotes/${modelo.lote.getIdLote()}" method="post" id="lote">
              <input class="form-control" type="hidden" id="idLote" value="${modelo.lote.getIdLote()}" />
              <div class="card-body">
                <div class="form-group row">
                  <div class="col-9 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Punto 1</span>
                    </div>
                    <input class="form-control" type="number" placeholder="Ingrese la longitud" id="punto1X"
                      value="${(modelo.lote.getPunto1())[0]}" required />
                    <input class="form-control" type="number" placeholder="Ingrese la latitud" id="punto1Y"
                      value="${(modelo.lote.getPunto1())[1]}" required />
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-9 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Punto 2</span>
                    </div>
                    <input class="form-control" type="number" placeholder="Ingrese la longitud" id="punto2X"
                      value="${(modelo.lote.getPunto2())[0]}" required />
                    <input class="form-control" type="number" placeholder="Ingrese la latitud" id="punto2Y"
                      value="${(modelo.lote.getPunto2())[1]}" required />
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-9 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Productor</span>
                    </div>
                    <select class="form-control" id="productor" required>
                      @for (var productor : modelo.productores)
                      @if (productor.getIdProductor() == modelo.lote.getProductor().getIdProductor())
                      <option value="${productor.getIdProductor()}" selected>${productor.toString()}</option>
                      @else
                      <option value="${productor.getIdProductor()}">${productor.toString()}</option>
                      @endif
                      @endfor
                    </select>
                  </div>
                </div>
              </div>
              <!-- /.card-body -->
              <div class="card-footer">
                <button type="submit" class="btn btn-primary"><i class="fas fa-save"></i> Guardar</button>
                <a href="." type="button" class="btn btn-secondary"> Volver </a>
              </div>
              <!-- /.card-footer-->
            </form>
          </div>
          <!-- /.card -->
        </div>
      </div>
    </div>
  </section>
  <!-- /.content -->
</div>
<!-- /.content-wrapper -->

<script src="/js/lote/actualizar.js"></script>

@tag.footer()