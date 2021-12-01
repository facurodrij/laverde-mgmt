@param edu.unam.jte.paginas.ModeloEmpleado modelo

@tag.head()

@tag.sidebar()

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
  <!-- Content Header (Page header) -->
  <section class="content-header">
    <div class="container-fluid">
      <div class="row mb-2">
        <div class="col-sm-6">
          <h1>Empleados</h1>
        </div>
        <div class="col-sm-6">
          <ol class="breadcrumb float-sm-right">
            <li class="breadcrumb-item"><a href="/">Inicio</a></li>
            <li class="breadcrumb-item active">Empleados</li>
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
              <h3 class="card-title">Lista de Empleados</h3>

              <div class="card-tools">
                <button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
                  <i class="fas fa-minus"></i>
                </button>
              </div>
            </div>
            <div class="card-body">
              <a href="/empleados/nuevo" class="btn btn-primary mb-3">
                <i class="fas fa-plus"></i> Nuevo empleado
              </a>
              <a href="/" type="button" class="btn btn-secondary mb-3"> Volver </a>
              <div class="table-responsive">
                <table class="table table-hover table-bordered" id="data">
                  <thead class="bg-light">
                    <tr>
                      <th scope="col" style="width: 10%;">Legajo</th>
                      <th scope="col" style="width: 20%;">CUIL</th>
                      <th scope="col" style="width: 20%;">Apellidos</th>
                      <th scope="col" style="width: 20%;">Nombres</th>
                      <th scope="col" style="width: 10%;">Opciones</th>
                    </tr>
                  </thead>

                  <tbody>
                    @for (var empleado : modelo.empleados)
                    <tr>
                      <td scope="row">${empleado.getLegajo()}</td>
                      <td>${empleado.getCuil()}</td>
                      <td>${empleado.getApellidos()}</td>
                      <td>${empleado.getNombres()}</td>
                      <td>
                        <a type="button" class="btn btn-warning btn-xs no-gutters"
                          href="/empleados/${empleado.getIdEmpleado()}">
                          <i class="fas fa-edit"></i>
                        </a>
                        <a type="button" class="btn btn-danger btn-xs no-gutters"
                          onClick="borrar(${empleado.getIdEmpleado()})">
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
<script src="/js/empleado/borrar.js"></script>

@tag.footer()