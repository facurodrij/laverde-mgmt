@param edu.unam.jte.paginas.ModeloCuadro modelo

@tag.head()

@tag.sidebar()

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
  <!-- Content Header (Page header) -->
  <section class="content-header">
    <div class="container-fluid">
      <div class="row mb-2">
        <div class="col-sm-6">
          <h1>Cuadros</h1>
        </div>
        <div class="col-sm-6">
          <ol class="breadcrumb float-sm-right">
            <li class="breadcrumb-item"><a href="/">Inicio</a></li>
            <li class="breadcrumb-item"><a href="/cuadros">Cuadros</a></li>
            <li class="breadcrumb-item active">${modelo.cuadro.getIdCuadro()}</li>
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
              <h3 class="card-title">Editar Cuadro</h3>
            </div>
            <form action="/cuadros/${modelo.cuadro.getIdCuadro()}" method="post" id="cuadro">
              <input class="form-control" type="hidden" id="idCuadro" value="${modelo.cuadro.getIdCuadro()}" />
              <div class="card-body">
                <div class="form-group row">
                  <div class="col-9 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Descripcion</span>
                    </div>
                    <input class="form-control" type="textarea" placeholder="Ingrese la descripcion" id="descripcion"
                      value="${modelo.cuadro.getDescripcion()}" required />
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-9 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Lote</span>
                    </div>
                    <select class="form-control" id="lote" required>
                      @for (var lote : modelo.lotes)
                      @if (lote.getIdLote() == modelo.cuadro.getLote().getIdLote())
                      <option value="${lote.getIdLote()}" selected>${lote.toString()}</option>
                      @else
                      <option value="${lote.getIdLote()}">${lote.toString()}</option>
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

<script src="/js/cuadro/actualizar.js"></script>

@tag.footer()