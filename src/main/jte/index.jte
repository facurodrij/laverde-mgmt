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
                <h3 class="card-title">Title</h3>

                <div class="card-tools">
                  <button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
                    <i class="fas fa-minus"></i>
                  </button>
                  <button type="button" class="btn btn-tool" data-card-widget="remove" title="Remove">
                    <i class="fas fa-times"></i>
                  </button>
                </div>
              </div>
              <div class="card-body">
                @if (!modelo.nombreUsuario.trim().isEmpty()) 
                    <h2><b> Hola ${modelo.nombreUsuario}! </b></h2>
                @else        
                    <form action="/" method="post" onsubmit="return validarUsuario();">
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label"> Usuario </label>
                            <input class="form-control col-sm-4" type="text" placeholder="nombre del usuario" id="nombreUsuario" name="nombreUsuario"/>
                        </div>
                        <button class="btn btn-primary"> Ingresar </button>
                    </form>
                @endif
              </div>
              <!-- /.card-body -->
              <div class="card-footer">
                Footer
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

@tag.footer()