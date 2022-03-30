@param edu.unam.jte.paginas.ModeloLote modelo

@tag.adminhead()

@tag.adminsidebar()

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
  <!-- Content Header (Page header) -->
  <section class="content-header">
    <div class="container-fluid">
      <div class="row mb-2">
        <div class="col-sm-6">
          <h1>Lotes</h1>
        </div>
      </div>
      @if (modelo.excepcion != null)
        @if (modelo.excepcion == "")
          <div class="alert alert-success alert-dismissible fade show" role="alert">
            El lote se ha registrado correctamente
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
        @else
          <div class="alert alert-danger alert-dismissible fade show" role="alert">
            ${modelo.excepcion}	
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
        @endif
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
              <h3 class="card-title">Crear Lote</h3>
            </div>
            <form action="/admin/lotes/nuevo" method="post" id="formulario">
              <div class="card-body">
                <div class="form-group row">
                  <div class="col-9 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Punto 1</span>
                    </div>
                    <input class="form-control" type="number" step="0.001" placeholder="Ingrese la longitud" id="punto1X" required />
                    <input class="form-control" type="number" step="0.001" placeholder="Ingrese la latitud" id="punto1Y" required />
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-9 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Punto 2</span>
                    </div>
                    <input class="form-control" type="number" step="0.001" placeholder="Ingrese la longitud" id="punto2X" required />
                    <input class="form-control" type="number" step="0.001" placeholder="Ingrese la latitud" id="punto2Y" required />
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-9 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Productor</span>
                    </div>
                    @if (!modelo.productores.isEmpty())
                    <select class="form-control" id="productor" required>
                      <option value="" hidden selected>Seleccione una opción</option>
                      @for (var productor : modelo.productores)
                        <option value="${productor.getIdProductor()}">${productor.toString()}</option>
                      @endfor
                    </select>
                    @else
                    <select class="form-control" id="productor" disabled>
                      <option value="" hidden selected>No hay productores</option>
                    </select>
                    @endif
                  </div>
                </div>
              </div>
              <!-- /.card-body -->
              <div class="card-footer">
                @if (!modelo.productores.isEmpty())
                  <button type="submit" class="btn btn-primary"><i class="fas fa-save"></i> Guardar </button>
                  <a href="." type="button" class="btn btn-secondary"> Volver </a>
                @else
                  <button disabled class="btn btn-primary"><i class="fas fa-save"></i> Guardar </button>
                  <a href="." type="button" class="btn btn-secondary"> Volver </a>
                  <div class="alert mt-3 alert-danger alert-dismissible fade show" role="alert">
                    Debe tener almenos un Productor registrado.	
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                  </div>
                @endif
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

<script src="/js/lote/crear.js"></script>

@tag.footer()