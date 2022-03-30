@param edu.unam.jte.paginas.ModeloCosecha modelo

@tag.adminhead()

@tag.adminsidebar()

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
  <!-- Content Header (Page header) -->
  <section class="content-header">
    <div class="container-fluid">
      <div class="row mb-2">
        <div class="col-sm-6">
          <h1>Cosechas</h1>
        </div>
      </div>
      @if (modelo.excepcion != null)
        @if (modelo.excepcion == "")
          <div class="alert alert-success alert-dismissible fade show" role="alert">
            La cosecha se ha registrado correctamente
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
              <h3 class="card-title">Crear Cosecha</h3>
            </div>
            <form action="/admin/cosechas/nuevo" method="post" id="cosecha">
              <div class="card-body">
                <div class="form-group row">
                  <div class="col-6 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Empleados</span>
                    </div>
                    @if (!modelo.empleados.isEmpty())
                    <select class="form-control" id="empleado" multiple required>
                      <option value="" hidden selected>Seleccione una opción</option>
                      @for (var empleado : modelo.empleados)
                      <option value="${empleado.getIdEmpleado()}">${empleado.toString()}</option>
                      @endfor
                    </select>
                    @else
                    <select class="form-control" id="empleado" disabled>
                      <option value="" hidden selected>No hay empleados</option>
                    </select>
                    @endif
                  </div>
                  <div class="col-6 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Cuadros</span>
                    </div>
                    @if (!modelo.cuadros.isEmpty())
                      <select class="form-control" id="cuadro" multiple required>
                        <option value="" hidden selected>Seleccione una opción</option>
                        @for (var cuadro : modelo.cuadros)
                          <option value="${cuadro.getIdCuadro()}">${cuadro.toString()}</option>
                        @endfor
                      </select>
                    @else
                      <select class="form-control" id="cuadro" disabled>
                        <option value="" hidden selected>No hay cuadros</option>
                      </select>
                    @endif
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-12 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Secaderos</span>
                    </div>
                    @if (!modelo.secaderos.isEmpty())
                    <select class="form-control" id="secadero" required>
                      <option value="" hidden selected>Seleccione una opción</option>
                      @for (var secadero : modelo.secaderos)
                      <option value="${secadero.getIdSecadero()}">${secadero.toString()}</option>
                      @endfor
                    </select>
                    @else
                    <select class="form-control" id="secadero" disabled>
                      <option value="" hidden selected>No hay secaderos</option>
                    </select>
                    @endif
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-6 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Peso Entrega</span>
                    </div>
                    <input class="form-control" type="number" step="0.001" placeholder="Ingrese el peso de entrega" id="pesoEntrega" required />
                    <small></small>
                  </div>
                  <div class="col-6 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Fecha Entrega</span>
                    </div>
                    <input class="form-control" type="date" id="tiempoEntrega" required />
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-6 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Peso Registro</span>
                    </div>
                    <input class="form-control" type="number" step="0.001" placeholder="Ingrese el peso de registro" id="pesoRegistro" required />
                    <small></small>
                  </div>
                  <div class="col-6 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Fecha Registro</span>
                    </div>
                    <input class="form-control" type="date" id="tiempoRegistro" required />
                  </div>
                </div>
              </div>
              <!-- /.card-body -->
              <div class="card-footer">
                @if (!(modelo.empleados.isEmpty() || modelo.cuadros.isEmpty() || modelo.secaderos.isEmpty()))
                  <button type="submit" class="btn btn-primary"><i class="fas fa-save"></i> Guardar</button>
                  <a href="." type="button" class="btn btn-secondary"> Volver </a>
                @else
                  <button disabled type="submit" class="btn btn-primary"><i class="fas fa-save"></i> Guardar</button>
                  <a href="." type="button" class="btn btn-secondary"> Volver </a>
                  <div class="alert mt-3 alert-danger alert-dismissible fade show" role="alert">
                    Debe tener un Empleado, un Cuadro y un Secadero registrado.	
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

<script src="/js/cosecha/crear.js"></script>

@tag.footer()