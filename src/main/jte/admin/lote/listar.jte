@param edu.unam.jte.paginas.ModeloLotes modelo

@tag.adminhead()

@tag.adminsidebar()

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
  <!-- Content Header (Page header) -->
  <section class="content-header">
    <div class="container-fluid">
      <div class="row mb-2">
        <div class="col-sm-6">
          <h1>Lotes</h1>
        </div>
      </div>
      @if (modelo.excepcion != null)
        @if (modelo.excepcion != "")
          <div class="alert alert-danger alert-dismissible fade show" role="alert">
            ${modelo.excepcion}	
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
        @else
          @if (modelo.eliminado != 0)
            <form action="/admin/lotes" method="post" id="form">
              <div class="alert alert-info alert-dismissible fade show" role="alert"
              style="margin-bottom: 0px;padding-bottom: 0px;">
                <p>
                  El lote con ID = ${modelo.eliminado} se ha eliminado correctamente
                  <input type="hidden" id="id" value="${modelo.eliminado}" />
                  <button type="submit" class="btn btn-light btn-xs float-right">
                    <i class="fas fa-reply"></i>
                    Deshacer
                  </button>
                  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                  </button>
                </p>
              </div>
            </form>
          @else
            <div class="alert alert-success alert-dismissible fade show" role="alert">
              El lote se ha actualizado correctamente
              <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
          @endif
        @endif
      @else
        @if (modelo.eliminado != 0)
          <div class="alert alert-dark alert-dismissible fade show" role="alert">
            Se ha recuperado el lote con ID = ${modelo.eliminado}
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
              <h3 class="card-title">Lista de Lotes</h3>
              <div class="card-tools">
                <a href="/admin/lotes/nuevo" class="btn btn-primary btn-xs float-right">
                  <i class="fas fa-plus"></i> Nuevo lote
                </a>
              </div>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-hover table-bordered" id="data">
                  <thead class="bg-light">
                    <tr>
                      <th scope="col" style="width: 10%;">#</th>
                      <th scope="col" style="width: 15%;">Punto 1</th>
                      <th scope="col" style="width: 15%;">Punto 2</th>
                      <th scope="col" style="width: 50%;">Productor</th>
                      <th scope="col" style="width: 10%;">Opciones</th>
                    </tr>
                  </thead>
                  <tbody>
                    @for (var lote : modelo.lotes)
                    <tr>
                      <td scope="row">${lote.getIdLote()}</td>
                      <td>${lote.getAbajoIzquierda_toString()}</td>
                      <td>${lote.getArribaDerecha_toString()}</td>
                      <td>${lote.getProductor().toString()}</td>
                      <td>
                        <a type="button" class="btn btn-warning btn-xs no-gutters" href="/admin/lotes/${lote.getIdLote()}">
                          <i class="fas fa-edit"></i>
                        </a>
                        <a type="button" class="btn btn-danger btn-xs no-gutters" onClick="borrar(&quot;lotes&quot;,${lote.getIdLote()})">
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
<script src="/js/borrar.js"></script>
<script src="/js/recuperar.js"></script>

@tag.footer()