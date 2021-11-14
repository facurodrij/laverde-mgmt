@param edu.unam.jte.paginas.ModeloProductor modelo

@tag.head()

@tag.sidebar()

<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Productores</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="/">Inicio</a></li>
              <li class="breadcrumb-item"><a href="/productores">Productores</a></li>
              <li class="breadcrumb-item active">${modelo.productor.getNombres()}</li>
            </ol>
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
                <h3 class="card-title">Editar Productor</h3>

                <div class="card-tools">
                  <button type="button" class="btn btn-tool" data-card-widget="collapse" title="Collapse">
                    <i class="fas fa-minus"></i>
                  </button>
                  <button type="button" class="btn btn-tool" data-card-widget="remove" title="Remove">
                    <i class="fas fa-times"></i>
                  </button>
                </div>
              </div>
              <form action="/productores/${modelo.productor.getIdProductor()}" method="post">
                    <div class="card-body">
                        <div class="form-group row">
                            <div class="col-6 input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">CUIT</span>
                                </div>
                                <input class="form-control" type="text" placeholder="Ingrese el cuit" name="cuit" value="${modelo.productor.getCuit()}"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-12 input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">Nombre</span>
                                </div>
                                <input class="form-control" type="text" placeholder="Ingrese el nombre" name="nombres" value="${modelo.productor.getNombres()}"/>
                            </div>                            
                        </div>
                        <div class="form-group row">
                            <div class="col-12 input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">Apellido</span>
                                </div>
                                <input class="form-control" type="text" placeholder="Ingrese el apellido" name="apellidos" value="${modelo.productor.getApellidos()}"/>
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

@tag.footer()