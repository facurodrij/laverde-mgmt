@param edu.unam.jte.paginas.ModeloIndex modelo

@tag.head()

@tag.sidebar()

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
  <!-- Content Header (Page header) -->
  <section class="content-header">
    <div class="container-fluid">
      <div class="row mb-2">
        <div class="col-sm-6">
          <h1>La Verde</h1>
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
              <h3 class="card-title">Administrador</h3>
            </div>
            <div class="card-body">
              @if (modelo.registrado)
                <h2><b> Iniciar Sesión </b></h2>
              @else
                <h2><b> Registrar </b></h2>
              @endif
              <form action="/admin" method="post">
                <input type="hidden" id="usuario" value="admin" />
                <div class="form-group row">
                  <label class="col-sm-2 col-form-label"> Usuario </label>
                  <input class="form-control col-sm-4" type="text" placeholder="Nombre del usuario" id="nombreUsuario"
                    name="nombreUsuario" required />
                </div>
                <div class="form-group row">
                  <label class="col-sm-2 col-form-label"> Contraseña </label>
                  <input class="form-control col-sm-4" type="password" placeholder="Contraseña" id="contrasenia"
                    name="contrasenia" required />
                </div>
                @if (modelo.registrado)
                  <button type="submit" class="btn btn-primary"> Ingresar </button>
                @else
                  <button type="submit" class="btn btn-primary"> Crear </button>
                @endif
              </form>
            </div>
            <!-- /.card-body -->
            <div class="card-footer">
              Este sistema pretende llevar control de las cosechas de La Verde S.A.,
              incluyendo los pesos (estos son, los kilos entregados al secadero y
              los kilos registrados en pesaje a campo; de los cuales se puede obtener
              la diferencia), los lotes, los cuadros, los cosecheros, los productores
              de las plantaciones y los secaderos de yerba.
            </div>
            <!-- /.card-footer-->
          </div>
          <!-- /.card -->
        </div>
      </div>
    </div>
  </section>
  <!-- /.content -->
</div>
<!-- /.content-wrapper -->

<script src="/js/admin/validarUsuario.js"></script>

@tag.footer()