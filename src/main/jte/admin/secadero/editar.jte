@param edu.unam.jte.paginas.ModeloSecadero modelo

@tag.adminhead()

@tag.adminsidebar()

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
  <!-- Content Header (Page header) -->
  <section class="content-header">
    <div class="container-fluid">
      <div class="row mb-2">
        <div class="col-sm-6">
          <h1>Secaderos</h1>
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
              <h3 class="card-title">Editar Secadero</h3>
            </div>
            <form action="/admin/secaderos/${modelo.secadero.getIdSecadero()}" method="post" id="secadero">
              <input class="form-control" type="hidden" id="idSecadero" value="${modelo.secadero.getIdSecadero()}" />
              <div class="card-body">
                <div class="form-group row">
                  <div class="col-6 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">CUIT</span>
                    </div>
                    <input class="form-control" type="text" placeholder="Ingrese el cuit" id="cuit"
                      value="${modelo.secadero.getCuit()}" required />
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-12 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Razon Social</span>
                    </div>
                    <input class="form-control" type="text" placeholder="Ingrese la razon social" id="razonSocial"
                      value="${modelo.secadero.getRazonSocial()}" required />
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

<script src="/js/secadero/actualizar.js"></script>

@tag.footer()