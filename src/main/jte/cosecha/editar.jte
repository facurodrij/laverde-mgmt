@param edu.unam.jte.paginas.ModeloCosecha modelo

@tag.head()

@tag.sidebar()

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
  <!-- Content Header (Page header) -->
  <section class="content-header">
    <div class="container-fluid">
      <div class="row mb-2">
        <div class="col-sm-6">
          <h1>Cosechas</h1>
        </div>
        <div class="col-sm-6">
          <ol class="breadcrumb float-sm-right">
            <li class="breadcrumb-item"><a href="/">Inicio</a></li>
            <li class="breadcrumb-item"><a href="/cosechas">Cosechas</a></li>
            <li class="breadcrumb-item active">Nuevo</li>
          </ol>
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
              <h3 class="card-title">Crear Cosecha</h3>
            </div>
            <form action="/cosechas/${modelo.cosecha.getIdCosecha()}" method="post" id="cosecha">
              <input class="form-control" type="hidden" id="idCosecha" value="${modelo.cosecha.getIdCosecha()}" />
              <div class="card-body">
                <div class="form-group row">
                  <div class="col-4 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Empleados</span>
                    </div>
                    <select class="form-control" id="empleado" multiple required>
                      @for (var empleado : modelo.empleados)
                        @if (modelo.cosecha.getEmpleados().contains(empleado))
                          <option value="${empleado.getIdEmpleado()}" selected>${empleado.toString()}</option>
                        @else
                          <option value="${empleado.getIdEmpleado()}">${empleado.toString()}</option>
                        @endif
                      @endfor
                    </select>
                  </div>
                  <div class="col-4 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Cuadros</span>
                    </div>
                    <select class="form-control" id="cuadro" multiple required>
                      @for (var cuadro : modelo.cuadros)
                        @if (modelo.cosecha.getCuadros().contains(cuadro))
                          <option value="${cuadro.getIdCuadro()}" selected>${cuadro.toString()}</option>
                        @else
                          <option value="${cuadro.getIdCuadro()}">${cuadro.toString()}</option>
                        @endif
                      @endfor
                    </select>
                  </div>
                  <div class="col-4 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Secaderos</span>
                    </div>
                    <select class="form-control" id="secadero" required>
                      @for (var secadero : modelo.secaderos)
                        @if (secadero.getIdSecadero() == modelo.cosecha.getSecadero().getIdSecadero())
                          <option value="${secadero.getIdSecadero()}" selected>${secadero.toString()}</option>
                        @else
                          <option value="${secadero.getIdSecadero()}">${secadero.toString()}</option>
                        @endif
                      @endfor
                    </select>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-6 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Peso Entrega</span>
                    </div>
                    <input class="form-control" type="number" placeholder="Ingrese el peso de entrega" id="pesoEntrega" value="${modelo.cosecha.getPesoEntrega()}" required />
                    <small></small>
                  </div>
                  <div class="col-6 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Fecha Entrega</span>
                    </div>
                    <input class="form-control" type="date" id="tiempoEntrega" value="${modelo.cosecha.getTiempoEntrega().toString()}" required />
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-6 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Peso Registro</span>
                    </div>
                    <input class="form-control" type="number" placeholder="Ingrese el peso de registro" id="pesoRegistro" value="${modelo.cosecha.getPesoRegistro()}" required />
                    <small></small>
                  </div>
                  <div class="col-6 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Fecha Registro</span>
                    </div>
                    <input class="form-control" type="date" id="tiempoRegistro" value="${modelo.cosecha.getTiempoRegistro().toString()}" required />
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

<script src="/js/cosecha/actualizar.js"></script>

@tag.footer()