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
            <li class="breadcrumb-item"><a href="/empleados">Empleados</a></li>
            <li class="breadcrumb-item active">Nuevo</li>
          </ol>
        </div>
      </div>
      @if (modelo.excepcion != null)
        @if (modelo.excepcion == "")
          <div class="alert alert-success alert-dismissible fade show" role="alert">
            El empleado se ha registrado correctamente
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
              <h3 class="card-title">Crear Empleado</h3>
            </div>
            <form action="/empleados/nuevo" method="post" id="empleado">
              <div class="card-body">
                <div class="form-group row">
                  <div class="col-4 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Legajo</span>
                    </div>
                    <input class="form-control" type="text" placeholder="Ingrese el legajo" id="legajo" required />
                  </div>
                  <div class="col-4 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">CUIL</span>
                    </div>
                    <input class="form-control" type="text" placeholder="Ingrese el cuil" id="cuil" required />
                  </div>
                  <div class="col-4 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">DNI</span>
                    </div>
                    <input class="form-control" type="text" id="dni" required />
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-12 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Nombre</span>
                    </div>
                    <input class="form-control" type="text" placeholder="Ingrese el nombre" id="nombres" required />
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-12 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Apellido</span>
                    </div>
                    <input class="form-control" type="text" placeholder="Ingrese el apellido" id="apellidos" required />
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-6 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Fecha Ingreso</span>
                    </div>
                    <input class="form-control" type="date" id="ingreso" required />
                  </div>
                  <div class="col-6 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Fecha Nacimiento</span>
                    </div>
                    <input class="form-control" type="date" id="nacimiento" required />
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

<script src="/js/empleado/crear.js"></script>

@tag.footer()