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
              <h3 class="card-title">Menú Principal</h3>
            </div>
            <div class="card-body">
              <h2><b> Bienvenido </b></h2>
              <h3>
                Por favor, elija alguno de los siguientes tipos de usuarios para
                iniciar sesión.
              </h3>
              <div style="margin-top:20px;">
                <button type="button" class="btn btn-warning" onClick="redireccionar(&quot;admin&quot;)">
                  Iniciar sesión como administrador
                </button>
              </div>
              <div style="margin-top:20px;">
                <button type="button" class="btn btn-success" onClick="redireccionar(&quot;productor&quot;)">
                  Iniciar sesión como productor
                </button>
              </div>
              <div style="margin-top:20px;">
                <button type="button" class="btn btn-primary" onClick="redireccionar(&quot;secadero&quot;)">
                  Iniciar sesión como secadero
                </button>
              </div>
            </div>
            <!-- /.card-body -->
            <div class="card-footer">
              Gracias por utilizar Laverdesa
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

<script src="/js/index.js"></script>

@tag.footer()