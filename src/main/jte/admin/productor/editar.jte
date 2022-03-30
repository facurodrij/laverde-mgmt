@param edu.unam.jte.paginas.ModeloProductor modelo

@tag.adminhead()

@tag.adminsidebar()

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
  <!-- Content Header (Page header) -->
  <section class="content-header">
    <div class="container-fluid">
      <div class="row mb-2">
        <div class="col-sm-6">
          <h1>Productores</h1>
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
              <h3 class="card-title">Editar Productor</h3>
            </div>
            <form action="/admin/productores/${modelo.productor.getIdProductor()}" method="post" id="productor">
              <input class="form-control" type="hidden" id="idProductor" value="${modelo.productor.getIdProductor()}" />
              <div class="card-body">
                <div class="form-group row">
                  <div class="col-6 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">CUIT</span>
                    </div>
                    <input class="form-control" type="text" placeholder="Ingrese el cuit" id="cuit"
                      value="${modelo.productor.getCuit()}" required />
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-12 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Nombre</span>
                    </div>
                    <input class="form-control" type="text" placeholder="Ingrese el nombre" id="nombres"
                      value="${modelo.productor.getNombres()}" required />
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-12 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Apellido</span>
                    </div>
                    <input class="form-control" type="text" placeholder="Ingrese el apellido" id="apellidos"
                      value="${modelo.productor.getApellidos()}" required />
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

<script src="/js/productor/actualizar.js"></script>

@tag.footer()