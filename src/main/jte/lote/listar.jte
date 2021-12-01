@param edu.unam.jte.paginas.ModeloLotes modelo

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
            <li class="breadcrumb-item active">Lotes</li>
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
              <h3 class="card-title">Lista de Lotes</h3>

              <div class="card-tools">
                <button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
                  <i class="fas fa-minus"></i>
                </button>
              </div>
            </div>
            <div class="card-body">
              <a href="/lotes/nuevo" class="btn btn-primary mb-3">
                <i class="fas fa-plus"></i> Nuevo lote
              </a>
              <a href="/" type="button" class="btn btn-secondary mb-3"> Volver </a>
              <div class="table-responsive">
                <table class="table table-hover table-bordered" id="data">
                  <thead class="bg-light">
                    <tr>
                      <th scope="col" style="width: 10%;">#</th>
                      <th scope="col" style="width: 15%;">Punto 1</th>
                      <th scope="col" style="width: 15%;">Punto 2</th>
                      <th scope="col" style="width: 50%;">Productor</th>
                      <th scope="col" style="width: 10%;">Opciones</th>
                    </tr>
                  </thead>

                  <tbody>
                    @for (var lote : modelo.lotes)
                    <tr>
                      <td scope="row">${lote.getIdLote()}</td>
                      <td>${lote.punto1_ToString()}</td>
                      <td>${lote.punto2_ToString()}</td>
                      <td>${lote.getProductor().toString()}</td>
                      <td>
                        <a type="button" class="btn btn-warning btn-xs no-gutters" href="/lotes/${lote.getIdLote()}">
                          <i class="fas fa-edit"></i>
                        </a>
                        <a type="button" class="btn btn-danger btn-xs no-gutters" onClick="borrar(${lote.getIdLote()})">
                          <i class="fas fa-trash-alt"></i>
                        </a>
                      </td>
                    </tr>
                    @endfor
                  </tbody>
                </table>
              </div>
            </div>
            <!-- /.card-body -->
          </div>
          <!-- /.card -->
        </div>
      </div>
    </div>
  </section>
  <!-- /.content -->
</div>
<!-- /.content-wrapper -->
<script src="/js/lote/borrar.js"></script>

@tag.footer()