@param edu.unam.jte.paginas.ModeloEmpleado modelo

@tag.adminhead()

@tag.adminsidebar()

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
  <!-- Content Header (Page header) -->
  <section class="content-header">
    <div class="container-fluid">
      <div class="row mb-2">
        <div class="col-sm-6">
          <h1>Empleados</h1>
        </div>
      </div>
      @if (modelo.excepcion != null)
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
          ${modelo.excepcion}	
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
              <h3 class="card-title">Editar Empleado</h3>
            </div>
            <form action="/admin/empleados/${modelo.empleado.getIdEmpleado()}" method="post" id="empleado">
              <input class="form-control" type="hidden" id="idEmpleado" value="${modelo.empleado.getIdEmpleado()}" />
              <div class="card-body">
                <div class="form-group row">
                  <div class="col-4 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Legajo</span>
                    </div>
                    <input class="form-control" type="text" placeholder="Ingrese el legajo" id="legajo"
                      value="${modelo.empleado.getLegajo()}" required />
                  </div>
                  <div class="col-4 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">CUIL</span>
                    </div>
                    <input class="form-control" type="text" placeholder="Ingrese el cuil" id="cuil"
                      value="${modelo.empleado.getCuil()}" required />
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-12 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Nombre</span>
                    </div>
                    <input class="form-control" type="text" placeholder="Ingrese el nombre" id="nombres"
                      value="${modelo.empleado.getNombres()}" required />
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-12 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Apellido</span>
                    </div>
                    <input class="form-control" type="text" placeholder="Ingrese el apellido" id="apellidos"
                      value="${modelo.empleado.getApellidos()}" required />
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-6 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Fecha Ingreso</span>
                    </div>
                    <input class="form-control" type="date" id="ingreso"
                     value="${modelo.empleado.getIngreso().toString()}" required />
                  </div>
                  <div class="col-6 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Fecha Nacimiento</span>
                    </div>
                    <input class="form-control" type="date" id="nacimiento"
                     value="${modelo.empleado.getNacimiento().toString()}" required />
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

<script src="/js/empleado/actualizar.js"></script>

@tag.footer()