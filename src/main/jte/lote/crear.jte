@import edu.unam.jte.paginas.ModeloProductores
@param ModeloProductores modelo

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
            <li class="breadcrumb-item active">Nuevo</li>
          </ol>
        </div>
      </div>
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

              <div class="card-tools">
                <button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
                  <i class="fas fa-minus"></i>
                </button>
                <button type="button" class="btn btn-tool" data-card-widget="remove" title="Remove">
                  <i class="fas fa-times"></i>
                </button>
              </div>
            </div>
            <form action="/lotes" method="post" id="lote">
              <div class="card-body">
                <div class="form-group row">
                  <div class="col-9 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Punto 1</span>
                    </div>
                    <input class="form-control" type="number" placeholder="Ingrese la longitud" id="punto1X" required />
                    <input class="form-control" type="number" placeholder="Ingrese la latitud" id="punto1Y" required />
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-9 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Punto 2</span>
                    </div>
                    <input class="form-control" type="number" placeholder="Ingrese la longitud" id="punto2X" required />
                    <input class="form-control" type="number" placeholder="Ingrese la latitud" id="punto2Y" required />
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-9 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Productor</span>
                    </div>
                    @if (!modelo.productores.isEmpty())
                    <select class="form-control" id="productor" required>
                      <option hidden selected>Seleccione una opción</option>
                      @for (var productor : modelo.productores)
                      <option value="${productor.getIdProductor()}">${productor.toString()}</option>
                      @endfor
                    </select>
                    @else
                    <select class="form-control" id="productor" disabled>
                      <option hidden selected>No hay productores</option>
                    </select>
                    @endif
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

<script src="/js/lote/crear.js"></script>

@tag.footer()