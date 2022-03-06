@param edu.unam.jte.paginas.ModeloCuadros modelo

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
            <li class="breadcrumb-item active">Cuadros</li>
          </ol>
        </div>
      </div>
      @if (modelo.excepcion != null)
        @if (modelo.excepcion != "")
          <div class="alert alert-danger alert-dismissible fade show" role="alert">
            ${modelo.excepcion}	
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
        @else
          @if (modelo.eliminado != 0)
            <form action="/cuadros" method="post" id="form">
              <div class="alert alert-info alert-dismissible fade show" role="alert">
                <p>
                  El cuadro con ID = ${modelo.eliminado} se ha eliminado correctamente
                  <input type="hidden" id="id" value="${modelo.eliminado}" />
                  <button type="submit" class="btn btn-light btn-xs float-right"> Deshacer </button>
                  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                  </button>
                </p>
              </div>
            </form>
          @else
            <div class="alert alert-success alert-dismissible fade show" role="alert">
              El cuadro se ha actualizado correctamente
              <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
          @endif
        @endif
      @else
        @if (modelo.eliminado != 0)
          <div class="alert alert-dark alert-dismissible fade show" role="alert">
            Se ha recuperado el cuadro con ID = ${modelo.eliminado}
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
              <h3 class="card-title">Lista de Cuadros</h3>
              <div class="card-tools">
                <button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
                  <i class="fas fa-minus"></i>
                </button>
              </div>
            </div>
            <div class="card-body">
              <a href="/cuadros/nuevo" class="btn btn-primary mb-3">
                <i class="fas fa-plus"></i> Nuevo cuadro
              </a>
              <a href="/" type="button" class="btn btn-secondary mb-3"> Volver </a>
              <div class="table-responsive">
                <table class="table table-hover table-bordered" id="data">
                  <thead class="bg-light">
                    <tr>
                      <th scope="col" style="width: 10%;">#</th>
                      <th scope="col" style="width: 15%;">Descripcion</th>
                      <th scope="col" style="width: 15%;">Lote</th>
                      <th scope="col" style="width: 10%;">Opciones</th>
                    </tr>
                  </thead>
                  <tbody>
                    @for (var cuadro : modelo.cuadros)
                      <tr>
                        <td scope="row">${cuadro.getIdCuadro()}</td>
                        <td>${cuadro.getDescripcion()}</td>
                        <td>${cuadro.getLote().toString()}</td>
                        <td>
                          <a type="button" class="btn btn-warning btn-xs no-gutters"
                            href="/cuadros/${cuadro.getIdCuadro()}">
                            <i class="fas fa-edit"></i>
                          </a>
                          <a type="button" class="btn btn-danger btn-xs no-gutters"
                            onClick="borrar(&quot;cuadros&quot;,${cuadro.getIdCuadro()})">
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
<script src="/js/borrar.js"></script>
<script src="/js/recuperar.js"></script>

@tag.footer()