@import edu.unam.jte.paginas.ModeloProductores
@param ModeloProductores modelo

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
              <li class="breadcrumb-item active">Productores</li>
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
                <h3 class="card-title">Lista de Productores</h3>

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
                <a href="/productores/nuevo" class="btn btn-primary mb-3">
                    <i class="fas fa-plus"></i> Nuevo productor
                </a>
                <a href="/" type="button" class="btn btn-secondary mb-3"> Volver </a>
                <div class="table-responsive">
                    <table class="table table-hover table-bordered" id="data">
                        <thead class="bg-light">
                            <tr>
                                <th scope="col" style="width: 10%;">#</th>
                                <th scope="col" style="width: 20%;">CUIT</th>
                                <th scope="col" style="width: 20%;">Apellidos</th>
                                <th scope="col" style="width: 20%;">Nombres</th>
                                <th scope="col" style="width: 10%;">Opciones</th>
                            </tr>
                        </thead>

                        <tbody>
                            @for (var productor : modelo.productores)
                                <tr>
                                    <td scope="row">${productor.getIdProductor()}</td>
                                    <td>${productor.getCuit()}</td>
                                    <td>${productor.getApellidos()}</td>
                                    <td>${productor.getNombres()}</td>
                                    <td>
                                        <a type="button" class="btn btn-warning btn-xs no-gutters" href="/productores/${productor.getIdProductor()}">
                                          <i class="fas fa-edit"></i>
                                        </a>
                                        <a type="button" class="btn btn-danger btn-xs no-gutters" onClick="borrar(${productor.getIdProductor()})">
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
  <script src="/js/productor/borrar.js"></script>

@tag.footer()