@param edu.unam.jte.paginas.ModeloCuadro modelo

@tag.head()

@tag.sidebar()

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
  <!-- Content Header (Page header) -->
  <section class="content-header">
    <div class="container-fluid">
      <div class="row mb-2">
        <div class="col-sm-6">
          <h1>Cuadros</h1>
        </div>
        <div class="col-sm-6">
          <ol class="breadcrumb float-sm-right">
            <li class="breadcrumb-item"><a href="/">Inicio</a></li>
            <li class="breadcrumb-item"><a href="/cuadros">Cuadros</a></li>
            <li class="breadcrumb-item active">Nuevo</li>
          </ol>
        </div>
      </div>
      @if (modelo.excepcion != null)
        @if (modelo.excepcion == "")
          <div class="alert alert-success alert-dismissible fade show" role="alert">
            El cuadro se ha registrado correctamente
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
              <h3 class="card-title">Crear Cuadro</h3>
            </div>
            <form action="/cuadros/nuevo" method="post" id="cuadro">
              <div class="card-body">
                <div class="form-group row">
                  <div class="col-10 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Lote</span>
                    </div>
                    @if (!modelo.lotes.isEmpty())
                      <select class="form-control" id="lote" required>
                        <option value="" hidden selected>Seleccione una opción</option>
                        @for (var lote : modelo.lotes)
                          <option value="${lote.getIdLote()}">${lote.toString()}</option>
                        @endfor
                      </select>
                    @else
                      <select class="form-control" id="lote" disabled>
                        <option value="" hidden selected>No hay lotes</option>
                      </select>
                    @endif
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-10 input-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">Descripción</span>
                    </div>
                    <input class="form-control" type="textarea" placeholder="Ingrese la descripción" id="descripcion"
                      required />
                  </div>
                </div>
                <div class="form-group row" id="puntos">
                  <div class="input-group">
                    <div class="d-block col-10 input-group-prepend center">
                      <span class="input-group-text">Puntos:</span>
                    </div>
                  </div>
                  <div class="col-10 input-group">
                    <input class="form-control" type="number" step="0.001" placeholder="Ingrese la longitud" id="puntoX" required />
                    <input class="form-control" type="number" step="0.001" placeholder="Ingrese la latitud" id="puntoY" required />
                  </div>
                  <div class="col-10 input-group">
                    <input class="form-control" type="number" step="0.001" placeholder="Ingrese la longitud" id="puntoX" required />
                    <input class="form-control" type="number" step="0.001" placeholder="Ingrese la latitud" id="puntoY" required />
                  </div>
                  @if (!modelo.lotes.isEmpty())
                    <div class="col-10 input-group" style="margin-top:20px;" id="boton">
                      <button type="button" class="btn btn-outline-primary float-left"
                        id="agregador" onClick="agregar()"> Agregar </button>
                    </div>
                  @endif
                </div>
              </div>
              <!-- /.card-body -->
              <div class="card-footer">
                @if (!modelo.lotes.isEmpty())
                  <button type="submit" class="btn btn-primary"><i class="fas fa-save"></i> Guardar</button>
                  <a href="." type="button" class="btn btn-secondary"> Volver </a>
                @else
                  <button disabled type="submit" class="btn btn-primary"><i class="fas fa-save"></i> Guardar</button>
                  <a href="." type="button" class="btn btn-secondary"> Volver </a>
                  <div class="alert mt-3 alert-danger alert-dismissible fade show" role="alert">
                    Debe tener almenos un Lote registrado.	
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

<script src="/js/cuadro/crear.js"></script>
<script src="/js/cuadro/puntos.js"></script>

@tag.footer()